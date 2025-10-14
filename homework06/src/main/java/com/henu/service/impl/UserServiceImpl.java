package com.henu.service.impl;

import com.henu.dao.UserDao;
import com.henu.entity.User;
import com.henu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService接口实现类
 * @Service：Spring注解，标识为Service层组件，交给Spring容器管理
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    // 依赖：UserDao对象（通过Spring依赖注入）
    private UserDao userDao;

    /**
     * 1. 构造方法注入（DI）
     * 通过构造方法接收UserDao对象，Spring会自动注入匹配的Bean
     */
    @Autowired  // 自动装配：根据类型匹配UserDao实现类
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 2. Setter方法注入（DI）
     * 如需使用Setter注入，可注释构造方法注入，启用以下代码
     */
    // @Autowired
    // public void setUserDao(UserDao userDao) {
    //     this.userDao = userDao;
    // }

    /**
     * 登录业务逻辑：调用DAO层方法验证用户名密码
     */
    @Override
    public User login(String username, String password) {
        // 1. 简单参数校验（实际项目需更完善的校验，如非空、长度等）
        if (username == null || password == null ||
                username.trim().isEmpty() || password.trim().isEmpty()) {
            return null;
        }
        // 2. 调用DAO层方法查询用户
        return userDao.findUserByUsernameAndPassword(username, password);
    }
}