package com.sriharyi.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "salary")
public class Salary {

    @Id
    @Column(name = "salary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salaryId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "base_salary", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double baseSalary;

    @Column(name = "bonus", columnDefinition = "DECIMAL(10,2)")
    private Double bonus;

    @Column(name = "allowance", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double allowance;

    @Column(name = "net_salary", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double netSalary;


    @Column(name = "pay_frequency", nullable = false, columnDefinition = "VARCHAR(10)")
    private String payFrequency;


    @Column(name = "pay_year", columnDefinition = "INT")
    private Integer payYear;


    @Column(name = "pay_date", nullable = false, columnDefinition = "DATE")
    private LocalDate payDate;


}
