package com.sriharyi.ems.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sriharyi.ems.dto.SalaryDto;
import com.sriharyi.ems.entity.Employee;
import com.sriharyi.ems.entity.Salary;
import com.sriharyi.ems.exception.SalaryNotFoundException;
import com.sriharyi.ems.repository.SalaryRepository;
import com.sriharyi.ems.service.EmployeeService;
import com.sriharyi.ems.service.SalaryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepository salaryRepository;

    private final EmployeeService employeeService;

    @Override
    public List<SalaryDto> getAllSalaries() {

        return salaryRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SalaryDto saveSalary(SalaryDto salary) {
        return convertToDto(salaryRepository.save(convertToEntity(salary)));
    }

    @Override
    public void deleteSalary(Integer id) {
        salaryRepository.deleteById(id);
    }

    private Salary convertToEntity(SalaryDto salaryDto) {
        Employee employee = employeeService.getEmployeeEntityById(salaryDto.getEmployeeId());
        return Salary.builder()
                .salaryId(salaryDto.getSalaryId())
                .employee(employee)
                .baseSalary(salaryDto.getBaseSalary())
                .bonus(salaryDto.getBonus())
                .payDate(salaryDto.getPayDate())
                .payYear(salaryDto.getPayYear())
                .payFrequency(salaryDto.getPayFrequency())
                .netSalary(salaryDto.getNetSalary())
                .build();
    }

    private SalaryDto convertToDto(Salary salary) {
        return SalaryDto.builder()
                .salaryId(salary.getSalaryId())
                .employeeId(salary.getEmployee().getEmployeeId())
                .baseSalary(salary.getBaseSalary())
                .bonus(salary.getBonus())
                .payDate(salary.getPayDate())
                .payYear(salary.getPayYear())
                .payFrequency(salary.getPayFrequency())
                .netSalary(salary.getNetSalary())
                .build();
    }

    @Override
    public SalaryDto getSalaryById(Integer id) {
        return convertToDto(salaryRepository.findById(id).orElseThrow(() -> new SalaryNotFoundException("Salary not found")));
    }

    @Override
    public List<SalaryDto> getSalaryByEmployeeId(Integer id) {
        return salaryRepository.findByEmployee_EmployeeId(id).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // find list of salaries for an employee for a given date range
    // @Override
    // public List<Salary> getSalariesByEmployeeIdAndDateRange(Integer id, String
    // startDate, String endDate) {
    // return salaryRepository.findSalariesByEmployeeIdAndDateRange(id, startDate,
    // endDate);
    // }

}
