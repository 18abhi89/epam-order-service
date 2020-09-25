package com.epam.service;

import java.util.List;

import com.epam.dto.OrderItemDto;
import com.epam.entity.OrderItem;

public interface OrderItemService {
	
	OrderItem save(OrderItemDto order);
	List<OrderItem> findByServiceId(long id);
}
