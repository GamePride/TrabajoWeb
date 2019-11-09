package com.gamepride.platform.service;


import java.util.List;

import com.gamepride.platform.model.Plan;

public interface IPlanService extends ICrudService<Plan> {

	List<Plan> findByType(String type) throws Exception;
}
