
package com.gamepride.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamepride.platform.model.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {

	List<Payment> findByTypePay(String typePay);
}