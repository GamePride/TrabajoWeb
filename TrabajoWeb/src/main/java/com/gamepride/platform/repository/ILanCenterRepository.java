package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.LanCenter;

@Repository
public interface ILanCenterRepository extends JpaRepository<LanCenter, Long> {
	
	List<LanCenter> findByName(String name);
	
	@Query("select l from LanCenter l join fetch l.events e join fetch l.personId p join fetch p.gamerId where l.id=?1")
	List<LanCenter> fetchByLanCenterIdWithEventsWithPeopleWithGamers(Long id);
}
