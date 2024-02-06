package com.sriharyi.ems.service;

import com.sriharyi.ems.dto.EmployeeDto;
import com.sriharyi.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> listAllEmployees();

    List<EmployeeDto> listAllEmployeesWithDepartmentId(Integer departmentId);

    EmployeeDto addEmployee(EmployeeDto employeeDto, Integer managerId);

    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    void deleteEmployeeByEmail(String email);

    void deleteEmployeeById(Integer id);

    EmployeeDto getEmployeeByEmail(String email);

    EmployeeDto getEmployeeById(Integer id);

    Employee getEmployeeEntityById(Integer id);
    
}
