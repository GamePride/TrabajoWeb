package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.LanCenter;

@Repository
public interface ILanCenterRepository extends JpaRepository<LanCenter, Long> {
	
	@Query("SELECT e FROM LanCenter e WHERE e.name LIKE %?1%")
	List<LanCenter> findLanCenterByName(String name);
}
