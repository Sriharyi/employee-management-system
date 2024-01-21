package com.sriharyi.ems.service;

import java.util.List;

import com.sriharyi.ems.entity.Employee;
import com.sriharyi.ems.entity.JobHistory;

public interface JobHistoryService {

    List<JobHistory> getAllJobHistories();

    JobHistory getJobHistoryById(Integer id);

    void deleteJobHistory(Integer id);

    void addJobHistory(Employee savedEmployee);
}
