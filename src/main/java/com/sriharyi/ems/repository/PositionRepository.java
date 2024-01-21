package com.sriharyi.ems.repository;

import com.sriharyi.ems.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PositionRepository extends JpaRepository<Position,Integer> {

    Position findByJobTitle(String jobTitle);

    

}
