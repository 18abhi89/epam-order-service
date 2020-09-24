package com.epam.service;

import com.epam.entity.Order;
import com.epam.entity.dto.OrderDto;

public interface OrderService {
	
	Order save(OrderDto order);
	Order findById(long id);
}
