package com.henu.dao;

import com.henu.entity.User;

/**
 * 数据访问层接口：定义用户相关的数据库操作
 */
public interface UserDao {
    /**
     * 根据用户名和密码查询用户（登录验证）
     * @param username 用户名
     * @param password 密码
     * @return 匹配的用户对象，无匹配则返回null
     */
    User findUserByUsernameAndPassword(String username, String password);
}