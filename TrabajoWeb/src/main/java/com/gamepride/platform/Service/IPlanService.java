<<<<<<< HEAD
package com.gamepride.platform.service;


import java.util.List;

import com.gamepride.platform.model.Plan;

public interface IPlanService extends ICrudService<Plan> {

	List<Plan> findByType(String type) throws Exception;

}
||||||| merged common ancestors
=======
package com.gamepride.platform.service;


import java.util.List;

import com.gamepride.platform.model.Plan;

public interface IPlanService extends ICrudService<Plan> {

	List<Plan> fetchPlanById(Long id) throws Exception;

}
>>>>>>> Adrian
