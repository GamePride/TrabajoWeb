package com.gamepride.platform.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.gamepride.platform.model.Subscription;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription, Long>{

	List<Subscription> findByType(String type);
	
	@Query("SELECT s FROM Subscription s left join fetch s.gamer g WHERE s.id=?1")
	Optional<Subscription> fetchBySubscriptionIdWithGamers(Long id);

	Collection<Subscription> findAllByOrderByTypeDesc();
}
