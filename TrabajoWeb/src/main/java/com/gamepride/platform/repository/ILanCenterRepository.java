package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.LanCenter;

@Repository
public interface ILanCenterRepository extends JpaRepository<LanCenter, Long> {
	
	List<LanCenter> findByName(String name);
	
	@Query("SELECT l FROM LanCenter l left join fetch l.events WHERE l.name LIKE %?1%")
	List<LanCenter> fetchByLanCenterIdWithEvents(String name);
}
