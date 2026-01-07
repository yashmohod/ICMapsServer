package com.ops.ICmaps.NavMode;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ops.ICmaps.Edge.Edge;

@Repository
public interface NavModeRepository extends JpaRepository<NavMode, Long> {

    boolean existsNavModeByName(String name);

    
}
