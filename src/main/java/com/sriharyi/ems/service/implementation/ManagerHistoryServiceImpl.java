package com.sriharyi.ems.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sriharyi.ems.entity.Employee;
import com.sriharyi.ems.entity.ManagerHistory;
import com.sriharyi.ems.repository.ManagerHistoryRepository;
import com.sriharyi.ems.service.ManagerHistoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManagerHistoryServiceImpl implements ManagerHistoryService {

    private final ManagerHistoryRepository managerHistoryRepository;

    @Override
    public List<ManagerHistory> getAllManagerHistories() {
        return managerHistoryRepository.findAll();
    }

    @Override
    public ManagerHistory getManagerHistoryById(Integer id) {
        return managerHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteManagerHistory(Integer id) {
        managerHistoryRepository.deleteById(id);
    }

    @Override
    public void addManagerHistory(Employee employee) {
        ManagerHistory record = ManagerHistory.builder()
                .employee(employee)
                .startDate(employee.getHireDate())
                .endDate(null)
                .build();
        managerHistoryRepository.save(record);
    }

}
