package com.gamepride.platform.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamepride.platform.model.Plan;
import com.gamepride.platform.repository.IPlanRepository;
import com.gamepride.platform.service.IPlanService;

@Service
public class PlanServiceImpl implements IPlanService {

	@Autowired
	private IPlanRepository planRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Plan> findAll() throws Exception {
		return planRepository.findAll();
	}

	@Transactional
	@Override
	public Plan save(Plan p) throws Exception {
		return planRepository.save(p);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Plan> findById(Long id) throws Exception {
		return planRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		planRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Plan> findByType(String type) throws Exception {
		return planRepository.findByType(type);
	}
}