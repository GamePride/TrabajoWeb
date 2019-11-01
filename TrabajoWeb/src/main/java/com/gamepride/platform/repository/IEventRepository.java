package com.gamepride.platform.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Event;

@Repository
public interface IEventRepository extends JpaRepository<Event, Long> {
	
	@Modifying
	@Query(value = "UPDATE events set published=true where id =?1 and vacancy>=10", nativeQuery = true)
	void publishEvent(Integer id);
	
	@Modifying
	@Query(value = "UPDATE events set published=false where id =?1", nativeQuery = true)
	void saveEvent(Integer id);
	
	@Query("SELECT e FROM Event e WHERE e.name LIKE %?1%")
	List<Event> findEventByName(String name);
}
