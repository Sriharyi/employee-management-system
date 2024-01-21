package com.sriharyi.ems.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder    
public class EmployeeDto {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Date hireDate;
    private String departmentName;
    private String jobTitle;
    private String role;
    private Double baseSalary;
}
