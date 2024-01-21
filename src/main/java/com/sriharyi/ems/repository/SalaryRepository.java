package com.sriharyi.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sriharyi.ems.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {

    List<Salary> findByEmployee_EmployeeId(Integer id);

//    @Query("SELECT s FROM Salary s JOIN s.employee e WHERE e.employeeId = :employeeId AND s.payDate >= :startDate AND s.payDate <= :endDate ORDER BY s.payDate DESC")
//    List<Salary> findSalariesByEmployeeIdAndDateRange(@Param("employeeId") Integer employeeId, @Param("startDate") String startDate, @Param("endDate") String endDate);
//
//    List<Salary> findByEmployeeId(Integer employeeId);
}
