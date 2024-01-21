package com.sriharyi.ems.service;

import com.sriharyi.ems.dto.PositionDto;
import com.sriharyi.ems.entity.Position;

import java.util.List;

public interface PositionService {

    List<PositionDto> getAllPositions();

    PositionDto getPositionById(Integer id);

    PositionDto savePosition(PositionDto positionDto);

    void deletePosition(Integer id);

    Position getByPositionName(String positionName);
}
