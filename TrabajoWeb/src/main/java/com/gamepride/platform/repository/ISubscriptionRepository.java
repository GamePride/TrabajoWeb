package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Subscription;

@Repository
public interface ISubscriptionRepository extends JpaRepository<Subscription, Long>{

	List<Subscription> findByType(String type);
}
