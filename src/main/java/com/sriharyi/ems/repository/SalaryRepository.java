package com.sriharyi.ems.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sriharyi.ems.entity.Employee;
import com.sriharyi.ems.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {

     List<Salary> findByPayDateBetween(LocalDate startDate, LocalDate endDate);

     List<Salary> findByEmployeeAndPayDateBetween(Employee employee, LocalDate startDate, LocalDate endDate);
}
