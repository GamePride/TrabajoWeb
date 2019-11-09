package com.gamepride.platform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.gamepride.platform.model.Subscription;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription, Long>{

<<<<<<< HEAD
	List<Subscription> findByType(String type);
||||||| merged common ancestors
	@Query("SELECT e FROM Subscription e WHERE e.name LIKE %?1%")
	List<Subscription> findSubscriptionByName(String name);
=======
	List<Subscription> findByType(String type);
	
	@Query("SELECT s FROM Subscription s left join fetch s.people p WHERE s.id=?1")
	Optional<Subscription> fetchBySubscriptionIdWithPeople(Long id);
>>>>>>> Developer
}
