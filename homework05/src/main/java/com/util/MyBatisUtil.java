package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    // 静态SqlSessionFactory（全局唯一）
    private static SqlSessionFactory sqlSessionFactory;

    // 静态代码块：初始化SqlSessionFactory（项目启动时执行一次）
    static {
        try {
            // 读取MyBatis核心配置文件
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 构建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("MyBatis配置文件加载失败！");
        }
    }

    // 获取SqlSession（自动提交事务，无需手动commit）
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession(true);
    }

    // 获取SqlSessionFactory（供外部使用）
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}