package icu.xiamu.springcache.service.impl;

import icu.xiamu.springcache.entity.User;
import icu.xiamu.springcache.repository.UserRepository;
import icu.xiamu.springcache.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public String getUserName(String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            return "not found";
        }
        return user.getName();
    }
}
