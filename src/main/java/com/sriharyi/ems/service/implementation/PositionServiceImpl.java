package com.sriharyi.ems.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sriharyi.ems.dto.PositionDto;
import com.sriharyi.ems.entity.Position;
import com.sriharyi.ems.exception.PositionNotFoundException;
import com.sriharyi.ems.repository.PositionRepository;
import com.sriharyi.ems.service.PositionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Override
    public List<PositionDto> getAllPositions() {
        return positionRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PositionDto getPositionById(Integer id) {
        return convertToDto(positionRepository.findById(id).orElseThrow(()-> new PositionNotFoundException("Position not found")));
    }

    @Override
    public PositionDto savePosition(PositionDto position) {
        return convertToDto(positionRepository.save(convertToEntity(position)));
    }

    @Override
    public void deletePosition(Integer id) {
        positionRepository.deleteById(id);
    }

    @Override
    public Position getByPositionName(String string) {
        return positionRepository.findByJobTitle(string);
    }

    private Position convertToEntity(PositionDto positionDto){
        return Position.builder()
                .positionId(positionDto.getPositionId())
                .jobTitle(positionDto.getJobTitle())
                .minSalary(positionDto.getMinSalary())
                .maxSalary(positionDto.getMaxSalary())
                .build();
    }

    private PositionDto convertToDto(Position position){
        return PositionDto.builder()
                .positionId(position.getPositionId())
                .jobTitle(position.getJobTitle())
                .minSalary(position.getMinSalary())
                .maxSalary(position.getMaxSalary())
                .build();
    }
}
