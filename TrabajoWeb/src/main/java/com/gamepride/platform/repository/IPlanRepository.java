<<<<<<< HEAD
package com.gamepride.platform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Plan;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Long> {

	List<Plan> findByType(String type);
	
	@Query("SELECT p FROM Plan p left join fetch p.subscriptions s WHERE p.id=?1")
	Optional<Plan> fetchPlanIdWithSubscriptions(Long id);
}
||||||| merged common ancestors
package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Plan;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Long> {

	@Query("SELECT e FROM Plan e WHERE e.name LIKE %?1%")
	List<Plan> findPlanByName(String name);
}
=======
package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Plan;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Long> {

	List<Plan> findByType(String type);
}
>>>>>>> Developer
