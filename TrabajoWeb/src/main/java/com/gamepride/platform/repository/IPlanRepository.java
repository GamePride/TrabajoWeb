package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Plan;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Long> {

	List<Plan> findByType(String type);
}
