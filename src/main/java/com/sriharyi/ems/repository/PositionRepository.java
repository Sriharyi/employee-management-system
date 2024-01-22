package com.sriharyi.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sriharyi.ems.entity.Position;


public interface PositionRepository extends JpaRepository<Position,Integer> {

    Position findByJobTitle(String jobTitle);

    

}
