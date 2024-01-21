package com.sriharyi.ems.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sriharyi.ems.dto.PositionDto;
import com.sriharyi.ems.service.PositionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/position")
@RequiredArgsConstructor
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
    public ResponseEntity<?> deletePosition(@RequestBody Integer id) {
        positionService.deletePosition(id);
        return ResponseEntity.ok().build();
    }

     @GetMapping("/getById")
    public ResponseEntity<PositionDto> getPositionById(@RequestBody Integer id) {
        return ResponseEntity.ok(positionService.getPositionById(id));
    }

      //get all positions
      @GetMapping("/getAllPositions")
      public ResponseEntity<List<PositionDto>> getAllPositions() {
          return ResponseEntity.ok(positionService.getAllPositions());
      }


}
