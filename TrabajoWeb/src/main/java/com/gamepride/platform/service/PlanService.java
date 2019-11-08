package com.gamepride.platform.service;


import java.util.List;

import com.gamepride.platform.model.Plan;

public interface PlanService extends CrudService<Plan> {

	List<Plan> fetchPlanById(Long id) throws Exception;

}
