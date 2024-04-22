package icu.xiamu.shuzimali1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/22
 */
public class Demo2 {
    public static void main(String[] args) {
        LikeRecorder recorder = new LikeRecorderImpl();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String name = scanner.next();
            recorder.like(name);
        }

        System.out.println(Arrays.toString(recorder.getLikeUsers()));
    }
}


/**
 * 点赞记录器
 */
interface LikeRecorder {

    /**
     * 若用户没有点赞过，则记录此次点赞行为。
     * 若用户曾经点赞过，则删除用户点赞记录。
     *
     * @param username 用户名
     */
    void like(String username);

    /**
     * 返回所有点赞的用户名
     *
     * @return 用户名数组
     */
    String[] getLikeUsers();

}

class LikeRecorderImpl implements LikeRecorder {

    private Set<String> nameSet;

    public LikeRecorderImpl() {
        nameSet = new HashSet<>();
    }

    @Override
    public void like(String username) {
        if (!nameSet.add(username)) {
            nameSet.remove(username);
        }
    }

    @Override
    public String[] getLikeUsers() {
        return nameSet.toArray(new String[0]);
    }
}
