package com.gamepride.platform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Person;
import com.gamepride.platform.model.Subscription;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription, Long>{

	
	List<Subscription> findByName(String name);
	@Query("SELECT e FROM Subscription s left join fetch s.gamers WHERE s.name LIKE %?1%")
	Optional<Subscription> fetchBySubscriptionIdWithGamers(Long id);
}
