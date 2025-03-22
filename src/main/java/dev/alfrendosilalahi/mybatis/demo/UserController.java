package dev.alfrendosilalahi.mybatis.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;

    @GetMapping
    public List<User> getUsers(@RequestParam int page, @RequestParam int size) {
        return userMapper.getUsers(getOffset(page, size), size);
    }

    private int getOffset(int page, int size) {
        return (page - 1) * size;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable final int id) {
        return userMapper.getUser(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        userMapper.createUser(user);
        return user;
    }

}
