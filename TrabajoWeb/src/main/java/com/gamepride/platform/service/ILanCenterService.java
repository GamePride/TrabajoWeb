package com.gamepride.platform.service;

import java.util.Collection;
import java.util.List;

import com.gamepride.platform.model.LanCenter;

public interface ILanCenterService {

	List<LanCenter> fetchByLanCenterIdWithEvents(Long id) throws Exception;
	
	List<LanCenter> fetchLanCenterByName(String name) throws Exception;
	
	List<LanCenter> fetchByLanCenterIdWithEventsWithPeopleWithGamers(Long id) throws Exception;

	public abstract int createLanCenter(LanCenter lancenter);
	public abstract int updateLanCenter(Long id, LanCenter lancenter);
	public abstract int deleteLanCenter(Long id);
	public abstract Collection<LanCenter> getLanCenters();

}
