package com.sriharyi.ems.controller;

import com.sriharyi.ems.dto.PositionDto;
import com.sriharyi.ems.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/position")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
public class PositionController {

    private final PositionService positionService;

    @PostMapping("/add")
    public ResponseEntity<PositionDto> addPosition(@RequestBody PositionDto positionDto) {
        return ResponseEntity.ok(positionService.savePosition(positionDto));
    }

    @PutMapping("/update")
    public ResponseEntity<PositionDto> updatePosition(@RequestBody PositionDto positionDto) {
        return ResponseEntity.ok(positionService.savePosition(positionDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePosition(@PathVariable Integer id) {
        positionService.deletePosition(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getById")
    public ResponseEntity<PositionDto> getPositionById(@RequestParam Integer id) {
        return ResponseEntity.ok(positionService.getPositionById(id));
    }

    // get all positions
    @GetMapping("/getAllPositions")
    public ResponseEntity<List<PositionDto>> getAllPositions() {
        return ResponseEntity.ok(positionService.getAllPositions());
    }

}
