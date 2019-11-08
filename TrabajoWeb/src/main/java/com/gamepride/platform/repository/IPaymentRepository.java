package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

	@Query("SELECT e FROM Payment e WHERE e.name LIKE %?1%")
	List<Payment> findPaymentByName(String name);
}
