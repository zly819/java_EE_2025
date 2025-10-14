package com.henu.service;

import com.henu.entity.User;

/**
 * 业务逻辑层接口：定义用户登录相关的业务操作
 */
public interface UserService {
    /**
     * 用户登录验证业务
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回用户对象，失败返回null
     */
    User login(String username, String password);
}