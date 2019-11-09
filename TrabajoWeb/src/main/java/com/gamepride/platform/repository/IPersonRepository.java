package com.gamepride.platform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

	@Query("SELECT p FROM Person p WHERE p.name LIKE %?1%")
	List<Person> fetchPersonByName(String name);
	
	@Query("SELECT p FROM Person p left join fetch p.lancenters l WHERE p.name=?1")
	Optional<Person> fetchByPersonIdWithLanCenters(Long id);
}
