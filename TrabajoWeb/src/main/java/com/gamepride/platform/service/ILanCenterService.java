package com.gamepride.platform.service;

import java.util.List;

import com.gamepride.platform.model.LanCenter;

public interface ILanCenterService extends ICrudService<LanCenter>{
	
	List<LanCenter> findByName(String name) throws Exception;
	
	List<LanCenter> fetchByLanCenterIdWithEventsWithPeopleWithGamers(Long id);
}
