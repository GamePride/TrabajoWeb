package com.gamepride.platform.service;

import java.util.List;

import com.gamepride.platform.model.Payment;

public interface IPaymentService extends ICrudService<Payment> {

	List<Payment> findByTypePay(String typePay) throws Exception;
}
