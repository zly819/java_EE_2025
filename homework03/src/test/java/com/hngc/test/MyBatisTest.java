package com.hngc.test;

import com.hngc.bean.Student;
import com.hngc.dao.StudentMapper;
import com.hngc.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyBatisTest {

    private SqlSession session;
    private StudentMapper mapper;

    @BeforeEach
    public void setUp() {
        session = MyBatisUtils.openSession();
        mapper = session.getMapper(StudentMapper.class);
    }

    @AfterEach
    public void tearDown() {
        if (session != null) session.close();
    }

    /* ---------- 多条件场景 ---------- */
    @Test
    public void findStudentByNameOrMajorTest() {
        System.out.println("=== 仅给姓名 ===");
        List<Student> list1 = mapper.findByNameOrMajor("张三", null);
        list1.forEach(System.out::println);

        System.out.println("=== 仅给专业 ===");
        List<Student> list2 = mapper.findByNameOrMajor(null, "软件工程");
        list2.forEach(System.out::println);

        System.out.println("=== 姓名专业都为空 ===");
        List<Student> list3 = mapper.findByNameOrMajor("", "");
        list3.forEach(System.out::println);
    }

    /* ---------- 单条件场景 ---------- */
    @Test
    public void findByListTest() {
        System.out.println("=== id < 5 ===");
        List<Student> list = mapper.findByIdLT5();
        list.forEach(System.out::println);
    }
}