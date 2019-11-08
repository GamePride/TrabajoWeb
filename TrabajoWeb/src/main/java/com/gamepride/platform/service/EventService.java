package com.gamepride.platform.service;

import java.util.List;
import java.util.Optional;

import com.gamepride.platform.model.Event;

public interface EventService extends CrudService<Event>{

	void publishEvent(Long id);
	
	void disableEvent(Long id);
	
	List<Event> fetchEventByName(String name);
	
	Optional<Event> fetchByEventIdWithGamers(Long id);
}
