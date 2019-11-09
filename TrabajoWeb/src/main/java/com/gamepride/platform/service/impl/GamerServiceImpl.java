package com.gamepride.platform.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gamepride.platform.model.Gamer;
import com.gamepride.platform.repository.IGamerRepository;
import com.gamepride.platform.service.IGamerService;

public class GamerServiceImpl implements IGamerService {

	@Autowired
	private IGamerRepository gamerRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Gamer> findAll() throws Exception {
		return gamerRepository.findAll();
	}

	@Transactional
	@Override
	public Gamer save(Gamer g) throws Exception {
		return gamerRepository.save(g);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Gamer> findById(Long id) throws Exception {
		return gamerRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		gamerRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Gamer> fetchGamerByUsername(String username) throws Exception {
		return gamerRepository.fetchGamerByUsername(username);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Gamer> fetchByGamerIdWithEvents(Long id) throws Exception {
		return gamerRepository.fetchByGamerIdWithEvents(id);
	}
}