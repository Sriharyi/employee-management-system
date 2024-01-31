package com.sriharyi.ems.service.implementation;

import com.sriharyi.ems.dto.DepartmentDto;
import com.sriharyi.ems.entity.Department;
import com.sriharyi.ems.exception.DepartmentNotFoundException;
import com.sriharyi.ems.repository.DepartmentRepository;
import com.sriharyi.ems.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        Department department = convertToEntity(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return convertToDto(savedDepartment);
    }

    @Override
    public List<DepartmentDto> listAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
        Department department = convertToEntity(departmentDto);
        if (department.getDepartmentId() == null || !departmentRepository.existsById(department.getDepartmentId())) {
            throw new DepartmentNotFoundException("Department not found");
        }
        Department updatedDepartment = departmentRepository.save(department);
        return convertToDto(updatedDepartment);
    }

    public DepartmentDto updateDepartment(Integer id, Integer managerId) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department == null) {
            throw new DepartmentNotFoundException("Department not found");
        }
        department.setCurrentManagerId(managerId);
        Department updatedDepartment = departmentRepository.save(department);
        return convertToDto(updatedDepartment);
    }

    @Override
    public void deleteDepartment(String departmentName) {
        departmentRepository.deleteByDepartmentName(departmentName);
    }

    @Override
    public DepartmentDto getDepartmentByName(String departmentName) {
        Department department = departmentRepository.findByDepartmentName(departmentName)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return convertToDto(department);
    }

    @Override
    public DepartmentDto getDepartmentById(Integer id) {
        Department department = departmentRepository.findById(id).orElse(null);
        return convertToDto(department);
    }

    private DepartmentDto convertToDto(Department department) {

        return DepartmentDto.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .currentManagerId(department.getCurrentManagerId())
                .build();

    }

    private Department convertToEntity(DepartmentDto departmentDto) {
        return Department.builder()
                .departmentId(departmentDto.getDepartmentId())
                .departmentName(departmentDto.getDepartmentName())
                .currentManagerId(departmentDto.getCurrentManagerId())
                .build();
    }
}