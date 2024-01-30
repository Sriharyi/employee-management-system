package com.sriharyi.ems.service;

import com.sriharyi.ems.dto.SalaryDto;

import java.util.List;

public interface SalaryService {

    List<SalaryDto> getAllSalaries();

    SalaryDto getSalaryById(Integer id);

    List<SalaryDto> getSalaryByEmployeeId(Integer id);

    SalaryDto saveSalary(SalaryDto salary);

    void deleteSalary(Integer id);

}
