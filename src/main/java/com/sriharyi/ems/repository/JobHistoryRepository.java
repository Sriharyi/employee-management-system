package com.sriharyi.ems.repository;

import com.sriharyi.ems.entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory,Integer> {
}
