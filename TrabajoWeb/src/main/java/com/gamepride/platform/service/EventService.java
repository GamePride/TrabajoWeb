package com.gamepride.platform.service;

import java.util.List;

import com.gamepride.platform.model.Event;

public interface EventService extends CrudService<Event>{

	
	List<Event> fetchEventByName(String name);
	
}
