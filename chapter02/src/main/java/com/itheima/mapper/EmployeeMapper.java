package com.itheima.mapper;

import com.itheima.domain.Employee;

import java.util.List;

public interface EmployeeMapper {
    int insertEmployee(Employee employee);

    int deleteEmployeeById(Integer id);

    int updateEmployee(Employee employee);

    Employee selectEmployeeById(Integer id);

    List<Employee> selectAllEmployees();
}
