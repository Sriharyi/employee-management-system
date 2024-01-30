package com.sriharyi.ems.repository;

import com.sriharyi.ems.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {

}
