package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

public interface UserMapper {

    // 增加用户
    int insertUser(User user);

    // 删除用户（根据ID）
    int deleteUserById(Integer id);

    // 修改用户
    int updateUser(User user);

    // 查询单个用户（根据ID）
    User selectUserById(Integer id);

    // 查询全部用户
    List<User> selectAllUsers();
}
