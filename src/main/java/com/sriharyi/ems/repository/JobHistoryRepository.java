package com.sriharyi.ems.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sriharyi.ems.entity.Employee;
import com.sriharyi.ems.entity.JobHistory;

public interface JobHistoryRepository extends JpaRepository<JobHistory,Integer> {
    JobHistory findByEmployee_EmployeeIdAndEndDateIsNull(Integer employeeId);

    List<JobHistory> findByEmployee(Employee savedEmployee);
}
