package com.gamepride.platform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

	
	List<Person> findByName(String name);
	
	@Query("SELECT e FROM Person e left join fetch e.lancenters WHERE e.name LIKE %?1%")
	Optional<Person> fetchByPersonIdWithLanCenters(Long id);
}
