package icu.xiamu.springcache.service.impl;

import icu.xiamu.springcache.entity.User;
import icu.xiamu.springcache.repository.UserRepository;
import icu.xiamu.springcache.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(cacheNames = "getUserName")
    @Override
    public String getUserName(String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            return "not found";
        }
        return user.getName();
    }

    // === 分割线, 下面是采用 caffeine 整合的  ===
    @CachePut(value = "user", key = "#user.id")
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @CacheEvict(value = "user", key = "#id")
    @Override
    public void remove(Integer id) {
        log.info("删除了id、key为" + id + "的数据缓存");
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public User getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(String.valueOf(id));
        return userOptional.orElse(null);
    }
}
