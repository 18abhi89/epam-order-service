package com.epam.service;

import org.springframework.stereotype.Service;

import com.epam.dto.OrderDto;
import com.epam.entity.Order;

@Service
public interface OrderService {
	
	Order save(OrderDto order);
	Order findById(long id);
}
