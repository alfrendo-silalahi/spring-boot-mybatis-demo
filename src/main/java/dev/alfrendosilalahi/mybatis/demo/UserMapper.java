package dev.alfrendosilalahi.mybatis.demo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    List<User> getUsers(int offset, int size);

    @Select("""
            SELECT * FROM users
            WHERE id = #{id}
            LIMIT 1
            """)
    Optional<User> getUser(int id);

    void createUser(User user);

}
