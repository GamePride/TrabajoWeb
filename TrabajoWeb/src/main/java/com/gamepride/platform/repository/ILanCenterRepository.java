<<<<<<< HEAD
package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.LanCenter;

@Repository
public interface ILanCenterRepository extends JpaRepository<LanCenter, Long>{
	
	@Query("SELECT l FROM LanCenter l left join fetch l.events WHERE l.id=?1")
	List<LanCenter> fetchByLanCenterIdWithEvents(Long id);

	@Query("SELECT l FROM LanCenter l WHERE l.name LIKE %?1%")
	List<LanCenter> fetchLanCenterByName(String name);
	 
	@Query("select l from LanCenter l join fetch l.events e join fetch l.personId p join fetch p.gamerId where l.id=?1")
	List<LanCenter> fetchByLanCenterIdWithEventsWithPeopleWithGamers(Long id);
	

	// Number of categories with specified name
	@Query("select count(lc.name) from LanCenter lc where lc.name = :name")
	public int countByName(@Param("name") String categoryName);
	public List<LanCenter> findAllByOrderByNameDesc();
}
=======
package com.gamepride.platform.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.LanCenter;

@Repository
public interface ILanCenterRepository extends JpaRepository<LanCenter, Long> {
	
	@Query("SELECT l FROM LanCenter l left join fetch l.events WHERE l.id=?1")
	List<LanCenter> fetchByLanCenterIdWithEvents(Long id);

	@Query("SELECT l FROM LanCenter l WHERE l.name LIKE %?1%")
	List<LanCenter> fetchLanCenterByName(String name);
	 
	@Query("select l from LanCenter l join fetch l.events e join fetch l.gamerId p where l.id=?1")
	List<LanCenter> fetchByLanCenterIdWithEventsWithGamers(Long id);
	
	@Query("select count(l.name) from LanCenter l where l.name = :name")
	int countByName(@Param("name") String name);
	
	Collection<LanCenter> findAllByOrderByNameDesc();
}
>>>>>>> César
