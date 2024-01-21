package com.sriharyi.ems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sriharyi.ems.entity.Department;
import com.sriharyi.ems.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmployeeId(Integer employeeId);

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByEmailAndPassword(String email, String password);

    void deleteByEmail(String email);   
    
    //list all employees by department name
    List<Employee> findByDepartment(Department department);

    //list all salaries by employee

}
