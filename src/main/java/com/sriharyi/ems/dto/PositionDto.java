package com.sriharyi.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionDto {
    private Integer positionId;
    private String jobTitle;
    private Double minSalary;
    private Double maxSalary;
}
