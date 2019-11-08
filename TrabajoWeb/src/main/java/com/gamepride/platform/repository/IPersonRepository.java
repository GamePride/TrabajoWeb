package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

	@Query("SELECT e FROM Person e WHERE e.name LIKE %?1%")
	List<Person> findPersonByName(String name);
}
