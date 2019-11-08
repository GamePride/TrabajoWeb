package com.gamepride.platform.service;

import java.util.Optional;

import com.gamepride.platform.model.Gamer;

public interface GamerService extends CrudService<Gamer> {

	
	Optional<Gamer> fetchByGamerIdWithEvents(Long id);
}
