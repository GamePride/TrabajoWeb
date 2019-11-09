package com.gamepride.platform.service;

import java.util.List;
import java.util.Optional;

import com.gamepride.platform.model.Gamer;

public interface IGamerService extends CrudService<Gamer> {

	List<Gamer> findByUsername(String username);
	
	Optional<Gamer> fetchByGamerIdWithEvents(Long id);
}
