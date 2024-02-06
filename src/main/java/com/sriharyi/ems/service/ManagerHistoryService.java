package com.sriharyi.ems.service;

import java.util.List;

import com.sriharyi.ems.entity.Employee;
import com.sriharyi.ems.entity.ManagerHistory;

public interface ManagerHistoryService {

    List<ManagerHistory> getAllManagerHistories();

    ManagerHistory getManagerHistoryById(Integer id);

    void addManagerHistory(Employee employee);

    void deleteManagerHistory(Integer id);

    void updateManagerHistory(Employee employee);
    
}
