package com.gamepride.platform.service;

<<<<<<< HEAD:TrabajoWeb/src/main/java/com/gamepride/platform/service/PlanService.java
=======

>>>>>>> 87a453a9e94edb3e0871cde1a7b7263b29e18806:TrabajoWeb/src/main/java/com/gamepride/platform/service/IPlanService.java
import java.util.List;

import com.gamepride.platform.model.Plan;

public interface IPlanService extends ICrudService<Plan> {

<<<<<<< HEAD:TrabajoWeb/src/main/java/com/gamepride/platform/service/PlanService.java
	List<Plan> fetchPlanById(Long id) throws Exception;

}
=======
	List<Plan> findByType(String type) throws Exception;

}
>>>>>>> 87a453a9e94edb3e0871cde1a7b7263b29e18806:TrabajoWeb/src/main/java/com/gamepride/platform/service/IPlanService.java
