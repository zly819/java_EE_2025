package com.example.userdemo.service;

import com.example.userdemo.entity.User;
import java.util.List;

public interface UserService {
    List<User> list();
    void add(User user);
    void update(User user);
    void delete(Integer id);
}