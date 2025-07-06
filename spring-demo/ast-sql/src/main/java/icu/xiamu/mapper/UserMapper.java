package icu.xiamu.mapper;

import icu.xiamu.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper // 告诉Spring这是一个MyBatis Mapper
public interface UserMapper {

    User selectById(@Param("id") Long id);

    List<User> selectAll();

    int insert(User user);

    int update(User user);

    int deleteById(@Param("id") Long id);
}