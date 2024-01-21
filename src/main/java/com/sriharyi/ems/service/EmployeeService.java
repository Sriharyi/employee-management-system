package com.sriharyi.ems.service;

import java.util.List;

import com.sriharyi.ems.dto.EmployeeDto;
import com.sriharyi.ems.entity.Employee;

public interface EmployeeService {
    List<EmployeeDto> listAllEmployees();

    List<EmployeeDto> listAllEmployeesWithDepartment(String departmentName);

    EmployeeDto addEmployee(EmployeeDto employeeDto);

    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    void deleteEmployeeByEmail(String email);

    void deleteEmployeeById(Integer id);

    EmployeeDto getEmployeeByEmail(String email);

    EmployeeDto getEmployeeById(Integer id);

    Employee getEmployeeEntityById(Integer id);
}
