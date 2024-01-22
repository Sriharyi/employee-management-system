package com.sriharyi.ems.service;

import java.util.List;

import com.sriharyi.ems.dto.SalaryDto;

public interface SalaryService {

    List<SalaryDto> getAllSalaries();

    SalaryDto getSalaryById(Integer id);

    List<SalaryDto> getSalaryByEmployeeId(Integer id);

    SalaryDto saveSalary(SalaryDto salary);

    void deleteSalary(Integer id);

    // List<Salary> getSalariesByEmployeeIdAndDateRange(Integer id, String
    // startDate, String endDate);
}
