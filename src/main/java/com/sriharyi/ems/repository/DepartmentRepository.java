package com.sriharyi.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sriharyi.ems.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    void deleteByDepartmentName(String departmentName);

    Department findByDepartmentName(String departmentName);




}
