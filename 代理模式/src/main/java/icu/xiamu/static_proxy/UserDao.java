package icu.xiamu.static_proxy;

/**
 * 目标类
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
