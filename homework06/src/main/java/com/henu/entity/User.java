package com.henu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok注解：自动生成getter/setter、toString、构造方法
@Data
@NoArgsConstructor  // 无参构造
@AllArgsConstructor // 全参构造
public class User {
    private Integer id;         // 用户ID
    private String username;    // 用户名
    private String password;    // 密码
    private String email;       // 邮箱
}