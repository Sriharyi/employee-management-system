package com.sriharyi.ems.service.implementation;

import com.sriharyi.ems.dto.SalaryDto;
import com.sriharyi.ems.entity.Employee;
import com.sriharyi.ems.entity.Salary;
import com.sriharyi.ems.exception.SalaryNotFoundException;
import com.sriharyi.ems.repository.SalaryRepository;
import com.sriharyi.ems.service.EmployeeService;
import com.sriharyi.ems.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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



    @Override
    public SalaryDto getSalaryById(Integer id) {
        return convertToDto(salaryRepository.findById(id).orElseThrow(() -> new SalaryNotFoundException("Salary not found")));
    }

    @Override
    public List<SalaryDto> getSalaryByEmployeeId(Integer id) {
        return employeeService.getEmployeeEntityById(id).getSalaries().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private Salary convertToEntity(SalaryDto salaryDto) {
        Employee employee = employeeService.getEmployeeEntityById(salaryDto.getEmployeeId());
        return Salary.builder()
                .salaryId(salaryDto.getSalaryId())
                .employee(employee)
                .baseSalary(salaryDto.getBaseSalary())
                .bonus(salaryDto.getBonus())
                .allowance(salaryDto.getAllowance())
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
                .allowance(salary.getAllowance())
                .payDate(salary.getPayDate())
                .payYear(salary.getPayYear())
                .payFrequency(salary.getPayFrequency())
                .netSalary(salary.getNetSalary())
                .build();
    }



}
