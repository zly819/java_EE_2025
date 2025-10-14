package com.henu.dao.impl;

import com.henu.dao.UserDao;
import com.henu.entity.User;
import org.springframework.stereotype.Repository;

/**
 * UserDao接口实现类
 * @Repository：Spring注解，标识为DAO层组件，交给Spring容器管理
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    /**
     * 模拟数据库查询（实际项目中需结合MyBatis/Spring JDBC操作真实数据库）
     * 此处为简化演示，直接硬编码验证（真实场景需替换为SQL查询）
     */
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        // 模拟从数据库查询到的用户数据（与SQL插入的测试数据一致）
        if ("admin".equals(username) && "123456".equals(password)) {
            return new User(1, "admin", "123456", "admin@henu.edu.cn");
        }
        // 用户名或密码不匹配，返回null
        return null;
    }
}