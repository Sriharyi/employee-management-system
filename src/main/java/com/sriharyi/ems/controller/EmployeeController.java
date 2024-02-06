package com.sriharyi.ems.controller;

import com.sriharyi.ems.dto.EmployeeDto;
import com.sriharyi.ems.service.DepartmentService;
import com.sriharyi.ems.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final DepartmentService departmentService;

    @GetMapping("/listAll")
    public ResponseEntity<List<EmployeeDto>> listAllEmployees() {
        return ResponseEntity.ok(employeeService.listAllEmployees());
    }

    @GetMapping("/listAllWithDepartment")
    public ResponseEntity<List<EmployeeDto>> listAllEmployeesWithDepartment(@RequestParam String departmentName) {
        Integer departmentId = departmentService.getDepartmentByName(departmentName).getDepartmentId();
        return ResponseEntity.ok(employeeService.listAllEmployeesWithDepartmentId(departmentId));
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto,@RequestParam int managerId) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeDto,managerId));
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    public ResponseEntity<EmployeeDto> getEmployee(@RequestParam String email) {
        return ResponseEntity.ok(employeeService.getEmployeeByEmail(email));
    }

    @GetMapping("/getById")
    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Integer id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

}
