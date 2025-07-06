package icu.xiamu;

import icu.xiamu.domain.User;
import icu.xiamu.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

/**
 * @author roudoukou
 * @date 2025/7/5
 */
@SpringBootTest // 开启Spring Boot测试环境
@Transactional // 确保每个测试都在事务中运行并回滚，不影响数据库
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        // 每次测试前可以清空表，确保测试的独立性
        // 注意：@Transactional 会在测试结束后回滚，所以这里不强制清空
        // 如果想手动清空，可以调用 delete all 方法
    }

    @Test
    void testInsertAndSelect() {
        User newUser = new User("Test User", 30);
        int rowsAffected = userMapper.insert(newUser);
        assertThat(rowsAffected).isEqualTo(1);
        assertThat(newUser.getId()).isNotNull(); // 检查自增ID是否设置

        User foundUser = userMapper.selectById(newUser.getId());
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getName()).isEqualTo("Test User");
        assertThat(foundUser.getAge()).isEqualTo(30);

        System.out.println("Inserted and Found User: " + foundUser);
    }

    @Test
    void testUpdate() {
        User user = new User("Update Me", 25);
        userMapper.insert(user); // 先插入一个用户

        user.setName("Updated Name");
        user.setAge(26);
        int rowsAffected = userMapper.update(user);
        assertThat(rowsAffected).isEqualTo(1);

        User updatedUser = userMapper.selectById(user.getId());
        assertThat(updatedUser.getName()).isEqualTo("Updated Name");
        assertThat(updatedUser.getAge()).isEqualTo(26);

        System.out.println("Updated User: " + updatedUser);
    }

    @Test
    void testDelete() {
        User user = new User("Delete Me", 40);
        userMapper.insert(user); // 先插入一个用户

        int rowsAffected = userMapper.deleteById(user.getId());
        assertThat(rowsAffected).isEqualTo(1);

        User deletedUser = userMapper.selectById(user.getId());
        assertThat(deletedUser).isNull(); // 确认用户已被删除

        System.out.println("User with ID " + user.getId() + " deleted.");
    }

    @Test
    void testSelectAll() {
        // userMapper.insert(new User("User A", 20));
        // userMapper.insert(new User("User B", 22));

        List<User> users = userMapper.selectAll();
        assertThat(users).isNotNull();
        assertThat(users.size()).isGreaterThanOrEqualTo(2); // 至少有两个
        System.out.println("All Users: " + users);
    }
}
