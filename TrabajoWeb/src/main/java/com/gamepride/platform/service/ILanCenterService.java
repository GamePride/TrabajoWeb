package com.gamepride.platform.service;

import java.util.Collection;
import java.util.List;

import com.gamepride.platform.model.LanCenter;

public interface ILanCenterService extends ICrudService<LanCenter>{

	List<LanCenter> fetchByLanCenterIdWithEvents(Long id) throws Exception;
	
	List<LanCenter> fetchLanCenterByName(String name) throws Exception;
	
	List<LanCenter> fetchByLanCenterIdWithEventsWithGamers(Long id) throws Exception;
	
	Collection<LanCenter> getLanCenters()throws Exception;
}