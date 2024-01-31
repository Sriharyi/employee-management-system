package com.sriharyi.ems.repository;

import com.sriharyi.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmployeeId(Integer employeeId);

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByEmailAndPassword(String email, String password);

    void deleteByEmail(String email);   
    
    //list all employees by department id
    List<Employee> findByDepartmentDepartmentId(Integer departmentId);

}
