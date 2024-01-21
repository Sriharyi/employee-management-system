package com.sriharyi.ems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data()
@NoArgsConstructor()
@AllArgsConstructor()
@Builder()
@Entity(name = "position")
public class Position {

    @Id()
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;

    @Column(name = "job_title" ,unique = true, nullable = false)
    private String jobTitle;

    @Column(name = "min_salary", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double minSalary;

    @Column(name = "max_salary", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double maxSalary;

    
}
