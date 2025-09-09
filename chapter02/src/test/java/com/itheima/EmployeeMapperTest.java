package com.itheima;

import com.itheima.domain.Employee;
import com.itheima.mapper.EmployeeMapper;
import com.itheima.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import java.util.List;

class EmployeeMapperTest {

    static SqlSession session;
    static EmployeeMapper mapper;

    @BeforeAll
    static void beforeAll() {
        session = MyBatisUtil.openSession();
        mapper = session.getMapper(EmployeeMapper.class);
    }

    @AfterAll
    static void afterAll() {
        session.close();
    }

    //1.增加员工
    @Test
    void testInsert() {
        Employee e = new Employee(null, "赵六", 24, "实习生");
        int n = mapper.insertEmployee(e);
        session.commit();
        Assertions.assertEquals(1, n);
        System.out.println("插入后主键：" + e.getId());
    }

    //2.删除员工
    @Test
    void testDelete() {
        int n = mapper.deleteEmployeeById(4);
        session.commit();
        System.out.println("删除行数：" + n);
    }

    //3.修改员工
    @Test
    void testUpdate() {
        Employee e = mapper.selectEmployeeById(2);
        e.setPosition("高级员工");
        int n = mapper.updateEmployee(e);
        session.commit();
        Assertions.assertEquals(1, n);
    }

    //4.查询单个员工
    @Test
    void testSelectById() {
        Employee e = mapper.selectEmployeeById(1);
        System.out.println(e);
        Assertions.assertNotNull(e);
    }

    //5.查询所有员工
    @Test
    void testSelectAll() {
        List<Employee> list = mapper.selectAllEmployees();
        list.forEach(System.out::println);
        Assertions.assertTrue(list.size() >= 3);
    }




}