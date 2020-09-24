package com.epam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.entity.Order;
import com.epam.entity.dto.OrderDto;
import com.epam.mapper.OrderMapper;
import com.epam.repository.OrderRepository;
import com.epam.service.OrderService;

public class OrderServiceImpl implements OrderService {

  @Autowired private OrderRepository orderRepository;
  @Autowired private OrderMapper mapper;

  @Override
  public Order save(OrderDto orderDto) {
    return orderRepository.save(mapper.getEntity(orderDto));
  }

  @Override
  public Order findById(long id) {
	  return orderRepository.findById(id);
  }
}
