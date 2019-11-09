<<<<<<< HEAD
package com.gamepride.platform.service;

import java.util.List;
import java.util.Optional;

import com.gamepride.platform.model.Subscription;

public interface ISubscriptionService extends ICrudService<Subscription>{

	List<Subscription> findByType(String type) throws Exception;
	
	Optional<Subscription> fetchBySubscriptionIdWithPeople(Long id) throws Exception;
}
||||||| merged common ancestors
=======
package com.gamepride.platform.service;

import java.util.List;
import java.util.Optional;

import com.gamepride.platform.model.Subscription;

public interface ISubscriptionService {

	List<Subscription> findByType(String type) throws Exception;
	
	Optional<Subscription> fetchBySubscriptionIdWithPeople(Long id) throws Exception;
}
>>>>>>> Adrian
