package com.epam.service;

import java.util.List;

import com.epam.entity.OrderItem;
import com.epam.entity.dto.OrderItemDto;

public interface OrderItemService {
	
	OrderItem save(OrderItemDto order);
	List<OrderItem> findByServiceId(long id);
}
