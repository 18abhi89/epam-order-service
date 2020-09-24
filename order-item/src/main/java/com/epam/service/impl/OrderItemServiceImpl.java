package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.entity.OrderItem;
import com.epam.entity.dto.OrderItemDto;
import com.epam.mapper.OrderItemMapper;
import com.epam.repository.OrderItemRepository;
import com.epam.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {

  @Autowired private OrderItemRepository orderItemRepository;
  @Autowired private OrderItemMapper itemMapper;

  @Override
  public OrderItem save(OrderItemDto orderItemDto) {
    return orderItemRepository.save(itemMapper.getEntity(orderItemDto));
  }

  @Override
  public List<OrderItem> findByServiceId(long id) {
	  return orderItemRepository.findByServiceId(id);
  }
}
