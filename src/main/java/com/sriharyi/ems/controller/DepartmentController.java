package com.sriharyi.ems.controller;

import com.sriharyi.ems.dto.DepartmentDto;
import com.sriharyi.ems.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    @PostMapping("/add")
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.addDepartment(departmentDto));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<DepartmentDto>> listAllDepartments() {
        return ResponseEntity.ok(departmentService.listAllDepartments());
    }

    @PutMapping("/update")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.updateDepartment(departmentDto));
    }

    //Patch mapping to update onlt the current manager id from department
    @PatchMapping("/update")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestParam Integer id, @RequestParam Integer managerId) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, managerId));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteDepartment(@RequestParam String departmentName) {
        departmentService.deleteDepartment(departmentName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public ResponseEntity<DepartmentDto> getDepartmentByName(@RequestParam String departmentName) {
        return ResponseEntity.ok(departmentService.getDepartmentByName(departmentName));
    }

    @GetMapping("/getById")
    public ResponseEntity<DepartmentDto> getDepartmentById(@RequestParam Integer id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }
}
