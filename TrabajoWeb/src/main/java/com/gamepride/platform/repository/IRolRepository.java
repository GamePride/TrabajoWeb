package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Role;

@Repository
public interface IRolRepository extends JpaRepository<Role, Long> {

	@Query("SELECT e FROM Role e WHERE e.name LIKE %?1%")
	List<Role> findRoleByName(String name);
}
