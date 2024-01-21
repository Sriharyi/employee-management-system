DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS Department;
DROP TABLE IF EXISTS Salary;
DROP TABLE IF EXISTS JobHistory;
DROP TABLE IF EXISTS Positions;
DROP TABLE IF EXISTS DepartmentManagerHistory;

CREATE TABLE Employee (
  employee_id INT PRIMARY KEY,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  email VARCHAR(30) UNIQUE NOT NULL,
  phone_number VARCHAR(12) NOT NULL,
  hire_date DATE,
  department_id INT,
  FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

CREATE TABLE Department (
  department_id INT PRIMARY KEY,
  department_name VARCHAR(30) NOT NULL,
  current_manager_id INT,
  FOREIGN KEY (current_manager_id) REFERENCES Employee(employee_id)
);

CREATE TABLE Salary (
  salary_id INT PRIMARY KEY,
  employee_id INT UNIQUE,
  salary NUMBER(10,2) NOT NULL,
  start_date DATE,
  end_date DATE,
  FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

CREATE TABLE JobHistory (
  job_history_id INT PRIMARY KEY,
  employee_id INT,
  department_id INT,
  job_title VARCHAR(30),
  start_date DATE,
  end_date DATE,
  FOREIGN KEY (employee_id) REFERENCES Employee(employee_id),
  FOREIGN KEY (department_id) REFERENCES Department(department_id),
  FOREIGN KEY (job_title) REFERENCES Positions(job_title)
);

CREATE TABLE Positions (
  job_title VARCHAR(30) PRIMARY KEY,
  min_salary NUMBER(10,2),
  max_salary NUMBER(10,2)
);

CREATE TABLE DepartmentManagerHistory (
  manager_id INT PRIMARY KEY,
  department_id INT,
  start_date DATE,
  end_date DATE,
  FOREIGN KEY (manager_id) REFERENCES Employee(employee_id),
  FOREIGN KEY (department_id) REFERENCES Department(department_id)
);
