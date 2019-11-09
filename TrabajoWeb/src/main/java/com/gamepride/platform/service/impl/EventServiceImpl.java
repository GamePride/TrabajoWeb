package com.gamepride.platform.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamepride.platform.model.Event;
import com.gamepride.platform.repository.IEventRepository;
import com.gamepride.platform.service.IEventService;

@Service
public class EventServiceImpl implements IEventService {

	@Autowired
	private IEventRepository eventRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Event> findAll() throws Exception {
		return eventRepository.findAll();
	}

	@Transactional
	@Override
	public Event save(Event e) throws Exception {
		return eventRepository.save(e);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Event> findById(Long id) throws Exception {
		return eventRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		eventRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public void publishedEvent(Long id) throws Exception {
		eventRepository.publishedEvent(id);
	}

	@Transactional(readOnly = true)
	@Override
	public void disabledEvent(Long id) throws Exception {
		eventRepository.disabledEvent(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public List<Event> fetchEventByName(String name) throws Exception {
		return eventRepository.fetchEventByName(name);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Event> fetchByEventIdWithGamers(Long id) throws Exception {
		return eventRepository.fetchByEventIdWithGamers(id);
	}
}
