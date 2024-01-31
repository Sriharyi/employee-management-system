package com.sriharyi.ems.repository;

import com.sriharyi.ems.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    void deleteByDepartmentName(String departmentName);

    Optional<Department> findByDepartmentName(String departmentName);
}
