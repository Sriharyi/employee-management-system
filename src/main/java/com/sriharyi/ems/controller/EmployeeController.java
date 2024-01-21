package com.sriharyi.ems.controller;

import com.sriharyi.ems.dto.EmployeeDto;
import com.sriharyi.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/listAll")
    public ResponseEntity<List<EmployeeDto>> listAllEmployees() {
        return ResponseEntity.ok(employeeService.listAllEmployees());
    }

    @GetMapping("/listAllWithDepartment")
    public ResponseEntity<List<EmployeeDto>> listAllEmployeesWithDepartment(@RequestParam String departmentName) {
        return ResponseEntity.ok(employeeService.listAllEmployeesWithDepartment(departmentName));
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeDto));
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<?> deleteEmployee(@RequestParam Integer id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam String email) {
        employeeService.deleteEmployeeByEmail(email);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public ResponseEntity<EmployeeDto> getEmployee(@RequestParam String email) {
        return ResponseEntity.ok(employeeService.getEmployeeByEmail(email));
    }

    @GetMapping("/getById")
    public ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam Integer id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    
}
