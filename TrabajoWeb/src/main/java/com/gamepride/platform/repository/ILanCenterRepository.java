package com.gamepride.platform.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.LanCenter;

@Repository
public interface ILanCenterRepository extends JpaRepository<LanCenter, Long>{
	
	List<LanCenter> findByName(String name);
	
	@Query("SELECT l FROM LanCenter l left join fetch l.events WHERE l.id=?1")
	Optional<LanCenter> fetchByLanCenterIdWithEvents(Long id);

	// Number of categories with specified name
	@Query("select count(lc.name) from LanCenter lc where lc.name = :name")
	public int countByName(@Param("name") String name);
	
	Collection<LanCenter> findAllByOrderByNameDesc();
}
