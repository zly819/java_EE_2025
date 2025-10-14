package com.henu;

import com.henu.entity.User;
import com.henu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring容器测试：验证IoC控制反转和DI依赖注入，测试用户登录功能
 */
public class LoginTest {

    @Test
    public void testLogin() {
        // 1. 加载Spring配置文件，初始化Spring容器（IoC容器）
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 从Spring容器中获取UserService对象（无需手动new，体现IoC）
        UserService userService = context.getBean("userService", UserService.class);

        // 3. 测试场景1：正确的用户名和密码
        String correctUsername = "admin";
        String correctPassword = "123456";
        User loginUser1 = userService.login(correctUsername, correctPassword);
        if (loginUser1 != null) {
            System.out.println("【登录成功】用户信息：" + loginUser1);
        } else {
            System.out.println("【登录失败】用户名或密码错误");
        }

        // 4. 测试场景2：错误的密码
        String wrongPassword = "654321";
        User loginUser2 = userService.login(correctUsername, wrongPassword);
        if (loginUser2 != null) {
            System.out.println("【登录成功】用户信息：" + loginUser2);
        } else {
            System.out.println("【登录失败】用户名或密码错误");
        }

        // 5. 关闭Spring容器（非必须，JVM退出时会自动关闭）
        ((ClassPathXmlApplicationContext) context).close();
    }
}