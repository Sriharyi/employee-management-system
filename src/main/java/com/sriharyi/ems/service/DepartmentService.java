package com.sriharyi.ems.service;

import com.sriharyi.ems.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto addDepartment(DepartmentDto departmentDto);

    List<DepartmentDto> listAllDepartments();

    DepartmentDto updateDepartment(DepartmentDto departmentDto);

    void deleteDepartment(String departmentName);

    DepartmentDto getDepartmentByName(String departmentName);

    DepartmentDto getDepartmentById(Integer id);

    DepartmentDto updateDepartment(Integer id, Integer managerId);

}
