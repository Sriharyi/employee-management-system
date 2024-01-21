package com.sriharyi.ems.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder  
public class SalaryDto {

    private Integer salaryId;
    private Integer employeeId;
    private Double baseSalary;
    private Double bonus;
    private Double allowance;
    private Double netSalary;
    private String payFrequency;
    private Integer payYear;
    private LocalDate payDate;
}
