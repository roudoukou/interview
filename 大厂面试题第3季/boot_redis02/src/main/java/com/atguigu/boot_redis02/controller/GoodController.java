package com.atguigu.boot_redis02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class GoodController {

    public static final String REDIS_LOCK = "atguiguLock";

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    String serverPort;

    @GetMapping("/buy_goods")
    public String buy_goods() {
        try {
            String value = UUID.randomUUID().toString() + Thread.currentThread().getName();
            Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, value);// setnx
            stringRedisTemplate.expire(REDIS_LOCK, 10L, TimeUnit.SECONDS);

            if (!flag) {
                return "抢锁失败";
            }

            String result = stringRedisTemplate.opsForValue().get("goods:001");
            int goodsNumber = result == null ? 0 : Integer.parseInt(result);

            if (goodsNumber > 0) {
                int realNumber = goodsNumber - 1;
                stringRedisTemplate.opsForValue().set("goods:001", String.valueOf(realNumber));
                System.out.println("成功买到商品, 库存还剩下: " + realNumber + " 件\t 服务提供端口: " + serverPort);

                return "成功买到商品, 库存还剩下: " + realNumber + " 件\t 服务提供端口: " + serverPort;
            } else {
                System.out.println("商品已经售完/活动结束/调用超时,欢迎下次光临" + "\t服务提供端口" + serverPort);
            }
            return "商品已经售完/活动结束/调用超时,欢迎下次光临" + "\t服务提供端口" + serverPort;
        } finally {
            stringRedisTemplate.delete(REDIS_LOCK);
        }
    }
}
