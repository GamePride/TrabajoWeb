package com.gamepride.platform.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamepride.platform.model.Subscription;
import com.gamepride.platform.repository.ISubscriptionRepository;
import com.gamepride.platform.service.ISubscriptionService;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService {

	@Autowired
	private ISubscriptionRepository subscriptionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Subscription> findByType(String type) throws Exception {
		return subscriptionRepository.findByType(type);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Subscription> fetchBySubscriptionIdWithPeople(Long id) throws Exception {
		return subscriptionRepository.fetchBySubscriptionIdWithPeople(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Subscription> findAll() throws Exception {
		return subscriptionRepository.findAll();
	}

	@Transactional
	@Override
	public Subscription save(Subscription s) throws Exception {
		return subscriptionRepository.save(s);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Subscription> findById(Long id) throws Exception {
		return subscriptionRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		subscriptionRepository.deleteById(id);
	}
}