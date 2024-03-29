package com.sriharyi.ems.service.implementation;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sriharyi.ems.authentication.dto.RegisterRequest;
import com.sriharyi.ems.authentication.service.AuthenticationService;
import com.sriharyi.ems.dto.EmployeeDto;
import com.sriharyi.ems.entity.Department;
import com.sriharyi.ems.entity.Employee;
import com.sriharyi.ems.entity.ManagerHistory;
import com.sriharyi.ems.exception.EmployeeNotFoundException;
import com.sriharyi.ems.exception.ManagerExeedEmployeeAdditionLimitException;
import com.sriharyi.ems.repository.DepartmentRepository;
import com.sriharyi.ems.repository.EmployeeRepository;
import com.sriharyi.ems.repository.ManagerHistoryRepository;
import com.sriharyi.ems.service.EmployeeService;
import com.sriharyi.ems.service.JobHistoryService;
import com.sriharyi.ems.service.ManagerHistoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final JobHistoryService jobHistoryService;

    private final ManagerHistoryService managerHistoryService;

    private final DepartmentRepository departmentRepo;

    private final AuthenticationService authenticationService;

    private final ManagerHistoryRepository managerHistoryRepository;

    @Override
    public List<EmployeeDto> listAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> listAllEmployeesWithDepartmentId(Integer departmentId) {
        return employeeRepository.findByDepartmentDepartmentId(departmentId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto, Integer managerId) {
        Employee employee = convertToEntity(employeeDto);
        if (employeeDto == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        if (employee.getHireDate() == null) {
            employee.setHireDate(new Date());
        }

        // before we add the employee we check whether the employee can be added by
        // manager or not
        if (employee.getRole().equalsIgnoreCase("EMPLOYEE")) {
            if (managerId != null) {
                ManagerHistory manager = managerHistoryRepository.findById(managerId).orElse(null);
                if (manager != null) {
                    if (manager.getEmployeeAdditionCount() >= 5) {
                        throw new ManagerExeedEmployeeAdditionLimitException(
                                "Manager has exceeded the limit of adding employees");
                    } else {
                        // update the manager EmployeeAdditionCount
                        manager.setEmployeeAdditionCount(manager.getEmployeeAdditionCount() + 1);
                        managerHistoryRepository.save(manager);
                    }
                }
            }
        }

        // add employee to the usertable to access the application
        RegisterRequest request = RegisterRequest.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .password(employee.getPassword())
                .role(employee.getRole())
                .build();

        Employee savedEmployee = employeeRepository.save(employee);
        authenticationService.register(request);

        // if role is manager then add manager record in managerHistory table
        if (employee.getRole().equalsIgnoreCase("MANAGER")) {
            managerHistoryService.addManagerHistory(employee);
        }

        // save hostory record for employee in job_history table
        jobHistoryService.addJobHistory(employee);

        return convertToDto(savedEmployee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = convertToEntity(employeeDto);
        if (employeeDto == null || employee == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        Employee updatedEmployee = employeeRepository.save(employee);

        // if role is manager then add manager record in managerHistory table
        if (updatedEmployee.getRole().equalsIgnoreCase("MANAGER")) {
            managerHistoryService.addManagerHistory(updatedEmployee);
        }

        // save hostory record for employee in job_history table
        jobHistoryService.addJobHistory(updatedEmployee);

        return convertToDto(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        if (id != null) {
            employeeRepository.deleteById(id);
        } else {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }

    @Override
    public void deleteEmployeeByEmail(String email) {
        if (email != null) {
            employeeRepository.deleteByEmail(email);
        } else {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }

    @Override
    public EmployeeDto getEmployeeByEmail(String email) {
        Optional<Employee> employee = employeeRepository.findByEmail(email);
        return convertToDto(employee.get());
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        if (id == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        Employee employee = employeeRepository.findById(id).orElse(null);
        return convertToDto(employee);
    }

    @Override
    public Employee getEmployeeEntityById(Integer id) {
        if (id == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return employeeRepository.findById(id).orElse(null);
    }

    private EmployeeDto convertToDto(Employee employee) {

        return EmployeeDto.builder()
                .employeeId(employee.getEmployeeId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .password(employee.getPassword())
                .phoneNumber(employee.getPhoneNumber())
                .hireDate(employee.getHireDate())
                .baseSalary(employee.getBaseSalary())
                .departmentName(employee.getDepartment().getDepartmentName())
                .jobTitle(employee.getJobTitle())
                .role(employee.getRole())
                .build();
    }

    private Employee convertToEntity(EmployeeDto employeeDto) {

        Department department = departmentRepo.findByDepartmentName(employeeDto.getDepartmentName()).orElse(null);

        return Employee.builder()
                .employeeId(employeeDto.getEmployeeId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .password(employeeDto.getPassword())
                .phoneNumber(employeeDto.getPhoneNumber())
                .hireDate(employeeDto.getHireDate())
                .baseSalary(employeeDto.getBaseSalary())
                .department(department)
                .role(employeeDto.getRole())
                .jobTitle(employeeDto.getJobTitle())
                .build();
    }

}