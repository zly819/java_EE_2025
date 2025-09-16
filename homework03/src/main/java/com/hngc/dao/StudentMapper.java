package com.hngc.dao;

import com.hngc.bean.Student;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface StudentMapper {

    /**
     * 多条件动态查询
     * @param name  学生姓名，可空
     * @param major 专业，可空
     * @return
     */
    List<Student> findByNameOrMajor(@Param("name") String name,
                                    @Param("major") String major);

    /**
     * 单条件：id < 5
     */
    List<Student> findByIdLT5();
}