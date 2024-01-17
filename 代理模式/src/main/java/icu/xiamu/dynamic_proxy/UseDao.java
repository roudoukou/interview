package icu.xiamu.dynamic_proxy;

public class UseDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
