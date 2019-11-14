package com.gamepride.platform.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Event;

@Repository
public interface IEventRepository extends JpaRepository<Event, Long> {
	
	@Modifying
	@Query(value = "UPDATE events set status='Publicado' where id =?1 and vacancy>=10", nativeQuery = true)
	void publishedEvent(Long id);
	
	@Modifying
	@Query(value = "UPDATE events set status='Creado' where id =?1", nativeQuery = true)
	void createdEvent(Long id);
	
	@Query("select e from Event e where e.name like %?1%")
	List<Event> fetchEventByName(String name);
	
	@Query("select e from Event e left join fetch e.gamers g where e.id=?1")
	Optional<Event> fetchByEventIdWithGamers(Long id);
	
	Collection<Event> findAllByOrderByNameDesc();
}