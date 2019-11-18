<<<<<<< HEAD

package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

	List<Payment> findByTypePay(String typePay);
=======

package com.gamepride.platform.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

	List<Payment> findByTypePay(String typePay);
	
	@Query("select count(p.typePay) from Payment p where p.typePay = :typePay")
	int countByTypePay(@Param("typePay") String typePay);
	
	Collection<Payment> findAllByOrderByTypePayDesc();
>>>>>>> César
}