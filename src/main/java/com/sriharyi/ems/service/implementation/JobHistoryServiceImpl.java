package com.sriharyi.ems.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sriharyi.ems.entity.Employee;
import com.sriharyi.ems.entity.JobHistory;
import com.sriharyi.ems.entity.Position;
import com.sriharyi.ems.repository.JobHistoryRepository;
import com.sriharyi.ems.service.JobHistoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobHistoryServiceImpl implements JobHistoryService {

    private final JobHistoryRepository jobHistoryRepository;

    private final PositionServiceImpl positionService;

    @Override
    public List<JobHistory> getAllJobHistories() {
        return jobHistoryRepository.findAll();
    }

    @Override
    public JobHistory getJobHistoryById(Integer id) {
        return jobHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteJobHistory(Integer id) {
        jobHistoryRepository.deleteById(id);
    }

    @Override
    public void addJobHistory(Employee savedEmployee) {
        Position position = positionService.getByPositionName(savedEmployee.getJobTitle());
        JobHistory record = JobHistory.builder()
                .employee(savedEmployee)
                .startDate(savedEmployee.getHireDate())
                .endDate(null)
                .position(position)
                .build();
        jobHistoryRepository.save(record);
    }

}
