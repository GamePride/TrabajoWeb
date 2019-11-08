package com.gamepride.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamepride.platform.model.EventGamer;

public interface IEventGamerRepository extends JpaRepository<EventGamer,Long> {
	
}
