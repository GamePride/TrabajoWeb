package com.gamepride.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamepride.platform.model.Role;

public interface IRoleRepository extends JpaRepository<Role,Long> {

}
