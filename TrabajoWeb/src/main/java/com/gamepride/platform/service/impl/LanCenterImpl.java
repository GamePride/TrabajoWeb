package com.gamepride.platform.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamepride.platform.model.LanCenter;
import com.gamepride.platform.repository.ILanCenterRepository;
import com.gamepride.platform.service.ILanCenterService;

@Service
public class LanCenterImpl implements ILanCenterService {

	@Autowired
	private ILanCenterRepository lanCenterRepository;
	
	@Override
	public List<LanCenter> findAll() throws Exception {
		return lanCenterRepository.findAll();
	}

	@Override
	public LanCenter save(LanCenter l) throws Exception {
		return lanCenterRepository.save(l);
	}

	@Override
	public Optional<LanCenter> findById(Long id) throws Exception {
		return lanCenterRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		lanCenterRepository.deleteById(id);
	}

	@Override
	public List<LanCenter> fetchByLanCenterIdWithEvents(Long id) throws Exception {
		return lanCenterRepository.fetchByLanCenterIdWithEvents(id);
	}

	@Override
	public List<LanCenter> fetchLanCenterByName(String name) throws Exception {
		return lanCenterRepository.fetchLanCenterByName(name);
	}

	@Override
	public List<LanCenter> fetchByLanCenterIdWithEventsWithPeopleWithGamers(Long id) throws Exception {
		return lanCenterRepository.fetchByLanCenterIdWithEventsWithPeopleWithGamers(id);
	}

}
