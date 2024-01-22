package com.sriharyi.ems.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sriharyi.ems.dto.SalaryDto;
import com.sriharyi.ems.service.SalaryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/salary")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
public class SalaryController {

    private final SalaryService salaryService;

    @PostMapping("/add")
    public ResponseEntity<SalaryDto> addSalary(@RequestBody SalaryDto salaryDto) {
        return ResponseEntity.ok(salaryService.saveSalary(salaryDto));
    }

    @PutMapping("/update")
    public ResponseEntity<SalaryDto> updateSalary(@RequestBody SalaryDto salaryDto) {
        return ResponseEntity.ok(salaryService.saveSalary(salaryDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteSalary(@RequestBody Integer id) {
        salaryService.deleteSalary(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getById")
    public ResponseEntity<SalaryDto> getSalaryById(@RequestBody Integer id) {
        return ResponseEntity.ok(salaryService.getSalaryById(id));
    }

    @GetMapping("/getByEmployeeId")
    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    public ResponseEntity<List<SalaryDto>> getSalaryByEmployeeId(@RequestBody Integer id) {
        return ResponseEntity.ok(salaryService.getSalaryByEmployeeId(id));
    }

    @GetMapping("/getAllSalaries")
    public ResponseEntity<List<SalaryDto>> getAllSalaries() {
        return ResponseEntity.ok(salaryService.getAllSalaries());
    }

}
