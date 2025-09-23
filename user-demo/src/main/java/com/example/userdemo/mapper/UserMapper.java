package com.example.userdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.userdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 不需要写任何方法，BaseMapper 已包含 CRUD
}
