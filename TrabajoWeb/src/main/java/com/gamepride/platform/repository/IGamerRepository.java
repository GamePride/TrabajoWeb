package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Gamer;

@Repository
public interface IGamerRepository extends JpaRepository<Gamer, Long> {
	
	@Query("SELECT e FROM Gamer e WHERE e.name LIKE %?1%")
	List<Gamer> findGamerByName(String name);
}