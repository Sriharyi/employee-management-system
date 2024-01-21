package com.sriharyi.ems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "job_history")
public class JobHistory {
    @Id
    @Column(name = "job_history_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobHistoryId;

    @Column(name = "start_date", columnDefinition = "DATE", nullable = false)
    private Date startDate;

    @Column(name = "end_date", columnDefinition = "DATE")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

}
