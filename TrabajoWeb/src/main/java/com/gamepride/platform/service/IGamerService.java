package com.gamepride.platform.service;

import java.util.List;
import java.util.Optional;

import com.gamepride.platform.model.Gamer;

public interface IGamerService extends ICrudService<Gamer> {

	List<Gamer> fetchGamerByUsername(String username) throws Exception;
	
	Optional<Gamer> fetchByGamerIdWithEvents(Long id) throws Exception;
}
