package com.gamepride.platform.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamepride.platform.model.Payment;
import com.gamepride.platform.repository.IPaymentRepository;
import com.gamepride.platform.service.IPaymentService;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentRepository paymentRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Payment> findAll() throws Exception {
		return paymentRepository.findAll();
	}

	@Transactional
	@Override
	public Payment save(Payment p) throws Exception {
		return paymentRepository.save(p);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Payment> findById(Long id) throws Exception {
		return paymentRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		paymentRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Payment> findByTypePay(String typePay) throws Exception {
		return paymentRepository.findByTypePay(typePay);
	}

}
