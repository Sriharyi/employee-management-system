# Project Title :- Employee Management System

## Overview

This is a simple Employee Management System. It is a web application that allows us to manage the employees of a company. It is developed using the Spring Boot Application . It is a CRUD application that supports the basic functions of Create, Read, Update and Delete. It also supports user authentication and authorization. It is a simple application that can be used as a starting point for a more complex application.


## Features

- **Employee Table:** Stores each employee’s data.
- **Employee History:** The employee's current job; also tracks the different roles the employee has previously held in the company.
- **Department Table:** Stores department data and indicates to which department an employee is assigned.
- **Department Manager History:** The current and past managers of each department. Managers are also employees.
- **Position Table:** A list of the different job roles in the company, including job title, job description and salary range.
- **Salary Table:** The current, past, and potentially future salary (i.e. when a raise is planned) paid to each employee.
- **User Authentication:** Secure access with different user roles.


## User Roles

1. **Admin:**
   - Full access to the system
   - Can create, update, delete, and view all resources
   - Can manage user accounts and roles

2. **Manager:**
   - Limited access to the system
   - Can create, update, delete, and view resources within their department or Position
   - Cannot manage user accounts and roles
   - Can Update employee personal information
   - Can view employee salary information
   - Can update employee salary information
   - Can Update employee job information

3. **Employee:**
   - Restricted access to the system
   - Can view resources related to their work
   - Cannot create, update, or delete resources
   - Can view employee personal information
   - Can view employee salary information


# API calls and its functions

## Authentication module

- `api`:- "api/auth/register"
<br>  `work`:- Here user,admin and content moderator can register. their role are specified internally using their email id and if the role is user then for them a document is created in page and follow request collection so that they no need to create a page again they can just update the details. it returns the jwt token

- `api`:- "api/auth/authenticate"
<br>  `work`:- when a registered person want to login they use this call. if the user name and password are correct they get JWT token 

- `api`:- "api/auth/logout" 
<br>  `work`:- when a user want to logout they use this call. it will delete the token from the database

# Employee Management Module

- `api`:- "/api/employee/add"
<br>  `work`:- This endpoint is used to add a new employee record. It accepts an `EmployeeDto` object in the request body and returns the created `EmployeeDto` object. Access is restricted to users with 'ROLE_ADMIN' or 'ROLE_MANAGER'.

- `api`:- "/api/employee/update"
<br>  `work`:- This endpoint is used to update an existing employee record. It accepts an `EmployeeDto` object in the request body and returns the updated `EmployeeDto` object. Access is restricted to users with 'ROLE_ADMIN' or 'ROLE_MANAGER'.

- `api`:- "/api/employee/delete"
<br>  `work`:- This endpoint is used to delete an employee record. It accepts an integer id in the request body. Access is restricted to users with 'ROLE_ADMIN' or 'ROLE_MANAGER'.

- `api`:- "/api/employee/getById"
<br>  `work`:- This endpoint is used to retrieve an employee record by its id. It accepts an integer id in the request body and returns the corresponding `EmployeeDto` object. Access is restricted to users with 'ROLE_ADMIN', 'ROLE_MANAGER', or 'ROLE_EMPLOYEE'.

- `api`:- "/api/employee/listAll"
<br>  `work`:- This endpoint is used to retrieve all employee records. It returns a list of `EmployeeDto` objects. Access is restricted to users with 'ROLE_ADMIN' or 'ROLE_MANAGER'.

- `api`:- "/api/employee/listAllWithDepartment"
<br>  `work`:- This endpoint is used to retrieve all employee records with their department. It returns a list of `EmployeeDto` objects. Access is restricted to users with 'ROLE_ADMIN' or 'ROLE_MANAGER'.

# Department Management Module

- `api`:- "/api/department/add"
<br>  `work`:- This endpoint is used to add a new department record. It accepts a `DepartmentDto` object in the request body and returns the created `DepartmentDto` object. Access is restricted to users with 'ROLE_ADMIN'.

- `api`:- "/api/department/listAll"
<br>  `work`:- This endpoint is used to retrieve all department records. It returns a list of `DepartmentDto` objects. Access is restricted to users with 'ROLE_MANAGER'and 'ROLE_ADMIN'.

- `api`:- "/api/department/update"
<br>  `work`:- This endpoint is used to update an existing department record. It accepts a `DepartmentDto` object in the request body and returns the updated `DepartmentDto` object. Access is restricted to users with 'ROLE_MANAGER' and 'ROLE_ADMIN'.

- `api`:- "/api/department/update"
<br>  `work`:- This endpoint is used to update the current manager id of a department. It accepts an integer id and managerId in the request parameters and returns the updated `DepartmentDto` object. Access is restricted to users with 'ROLE_ADMIN'.

- `api`:- "/api/department/delete"
<br>  `work`:- This endpoint is used to delete a department record. It accepts a string departmentName in the request parameters. Access is restricted to users with 'ROLE_ADMIN'.

- `api`:- "/api/department/get"
<br>  `work`:- This endpoint is used to retrieve a department record by its name. It accepts a string departmentName in the request parameters and returns the corresponding `DepartmentDto` object. Access is restricted to users with 'ROLE_MANAGER'and 'ROLE_ADMIN'.

- `api`:- "/api/department/getById"
<br>  `work`:- This endpoint is used to retrieve a department record by its id. It accepts an integer id in the request parameters and returns the corresponding `DepartmentDto` object. Access is restricted to users with 'ROLE_MANAGER'and 'ROLE_ADMIN'.

## Position Management Module

- `api`:- "/api/position/add"
<br>  `work`:- This endpoint is used to add a new position record. It accepts a `PositionDto` object in the request body and returns the created `PositionDto` object. Access is restricted to users with 'ROLE_ADMIN' or 'ROLE_MANAGER'.

- `api`:- "/api/position/listAll"
<br>  `work`:- This endpoint is used to retrieve all position records. It returns a list of `PositionDto` objects. Access is restricted to users with 'ROLE_MANAGER'or 'ROLE_ADMIN'.

- `api`:- "/api/position/update"
<br>  `work`:- This endpoint is used to update an existing position record. It accepts a `PositionDto` object in the request body and returns the updated `PositionDto` object. Access is restricted to users with 'ROLE_MANAGER' or 'ROLE_ADMIN'.

- `api`:- "/api/position/delete"
<br>  `work`:- This endpoint is used to delete a position record. It accepts a string positionName in the request parameters. Access is restricted to users with 'ROLE_ADMIN' or 'ROLE_MANAGER'.

- `api`:- "/api/position/get"
<br>  `work`:- This endpoint is used to retrieve a position record by its name. It accepts a string positionName in the request parameters and returns the corresponding `PositionDto` object. Access is restricted to users with 'ROLE_MANAGER'or 'ROLE_ADMIN'.

- `api`:- "/api/position/getById"
<br>  `work`:- This endpoint is used to retrieve a position record by its id. It accepts an integer id in the request parameters and returns the corresponding `PositionDto` object. Access is restricted to users with 'ROLE_MANAGER' or 'ROLE_ADMIN'.

## Salary Management Module
- `api`:- "/api/salary/add"
<br> `work`:- This endpoint is used to add a new salary record. It accepts a SalaryDto object in the request body and returns the created SalaryDto object. Access is restricted to users with 'ROLE_ADMIN' or 'ROLE_MANAGER'.

- `api` "/api/salary/update" 
<br> `work`:- This endpoint is used to update an existing salary record. It accepts a SalaryDto object in the request body and returns the updated SalaryDto object. Access is restricted to users with 'ROLE_ADMIN' or 'ROLE_MANAGER'.

- `api`"/api/salary/delete" 
<br>`work`:- This endpoint is used to delete a salary record. It accepts an integer id in the request body. Access is restricted to users with 'ROLE_ADMIN' or 'ROLE_MANAGER'.

- `api` "/api/salary/getById" 
<br> `work`:- This endpoint is used to retrieve a salary record by its id. It accepts an integer id in the request body and returns the corresponding SalaryDto object. Access is restricted to users with 'ROLE_ADMIN' ,'ROLE_EMPLOYEE' or 'ROLE_MANAGER'.

- `api` "/api/salary/getByEmployeeId"
<br> `work`:- This endpoint is used to retrieve all salary records for a specific employee. It accepts an integer employee id in the request body and returns a list of SalaryDto objects. Access is restricted to users with 'ROLE_EMPLOYEE','ROLE_MANAGER' or 'ROLE_ADMIN'.
