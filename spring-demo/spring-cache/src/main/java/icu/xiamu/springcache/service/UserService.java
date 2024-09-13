package icu.xiamu.springcache.service;

import icu.xiamu.springcache.entity.User;

public interface UserService {

    String getUserName(String name);

    User save(User user);

    User getUserById(Integer id);

    void remove(Integer id);

}
