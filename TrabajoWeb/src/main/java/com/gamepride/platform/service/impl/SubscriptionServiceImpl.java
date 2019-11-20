package com.gamepride.platform.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamepride.platform.model.Subscription;
import com.gamepride.platform.repository.ISubscriptionRepository;
import com.gamepride.platform.service.ISubscriptionService;

/*@Service
public class SubscriptionServiceImpl implements ISubscriptionService {

	@Autowired
	private ISubscriptionRepository subscriptionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Subscription> findByType(String type) throws Exception {
		return subscriptionRepository.findByType(type);
	}

	@Transactional
	@Override
	public int create(Subscription s) throws Exception {
		int result=subscriptionRepository.countByType(s.getType());
		if(result==0)
		{
			subscriptionRepository.save(s);
		}
		return result;
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
<<<<<<< HEAD
}*/
=======

	@Transactional(readOnly = true)
	@Override
	public Collection<Subscription> getSubscription() throws Exception {
		return subscriptionRepository.findAllByOrderByTypeDesc();
	}
}
>>>>>>> fe0f9ba661ea21db11ec7eeecbbee3011ff53132
