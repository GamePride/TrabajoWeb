package com.gamepride.platform.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamepride.platform.model.LanCenter;
import com.gamepride.platform.repository.ILanCenterRepository;
import com.gamepride.platform.service.ILanCenterService;

@Service
public class LanCenterImpl implements ILanCenterService {

	@Autowired
	private ILanCenterRepository lanCenterRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<LanCenter> findAll() throws Exception {
		return lanCenterRepository.findAll();
	}

	@Transactional
	@Override
	public LanCenter save(LanCenter l) throws Exception {
		return lanCenterRepository.save(l);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<LanCenter> findById(Long id) throws Exception {
		return lanCenterRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		lanCenterRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<LanCenter> fetchByLanCenterIdWithEvents(Long id) throws Exception {
		return lanCenterRepository.fetchByLanCenterIdWithEvents(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<LanCenter> fetchLanCenterByName(String name) throws Exception {
		return lanCenterRepository.fetchLanCenterByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public List<LanCenter> fetchByLanCenterIdWithEventsWithGamers(Long id) throws Exception {
		return lanCenterRepository.fetchByLanCenterIdWithEventsWithGamers(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<LanCenter> getLanCenters() throws Exception {
		return lanCenterRepository.findAllByOrderByNameDesc();
	}
}
