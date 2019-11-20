package com.gamepride.platform.service;

import java.util.Collection;
import java.util.List;

import com.gamepride.platform.model.Subscription;

public interface ISubscriptionService extends ICrudService<Subscription>{

	List<Subscription> findByType(String type) throws Exception;
	
	Collection<Subscription> getSubscription() throws Exception;
}
