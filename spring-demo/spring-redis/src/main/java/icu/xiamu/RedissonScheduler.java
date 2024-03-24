package icu.xiamu;


import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonScheduler {

    private static final String LOCK_KEY = "task_lock";
    private static final String TASK_CHANNEL = "task_channel";

    public static void main(String[] args) {
        // 创建Redisson客户端
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.1.100:6379").setPassword("leadnews");
        RedissonClient redisson = Redisson.create(config);

        // 获取分布式锁
        RLock lock = redisson.getLock(LOCK_KEY);
        lock.lock();

        try {
            // 执行定时任务
            System.out.println("执行定时任务...");

            // 模拟任务执行时间
            Thread.sleep(5000);

            // 发布消息到频道
            redisson.getTopic(TASK_CHANNEL).publish("task_completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            lock.unlock();
            redisson.shutdown();
        }
    }
}