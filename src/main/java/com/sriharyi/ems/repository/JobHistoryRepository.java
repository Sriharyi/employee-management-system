package com.sriharyi.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sriharyi.ems.entity.JobHistory;

public interface JobHistoryRepository extends JpaRepository<JobHistory,Integer> {
    
    // @Query("SELECT jh FROM JobHistory jh WHERE jh.employee.employeeId = :employeeId AND jh.endDate IS NULL")
    // JobHistory findCurrentJobHistoryByEmployeeId(@Param("employeeId") Integer employeeId);

    JobHistory findByEmployee_EmployeeIdAndEndDateIsNull(Integer employeeId);
}
