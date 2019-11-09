package com.gamepride.platform.service;

import java.util.List;
import java.util.Optional;

import com.gamepride.platform.model.Event;

public interface IEventService extends ICrudService<Event>{

	void publishedEvent(Long id) throws Exception;
	
	void disabledEvent(Long id) throws Exception;
	
	List<Event> fetchEventByName(String name) throws Exception;
	
	Optional<Event> fetchByEventIdWithGamers(Long id) throws Exception;
}
