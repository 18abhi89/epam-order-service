package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.epam.dto.OrderItemDto;
import com.epam.entity.OrderItem;
import com.epam.mapper.OrderItemMapper;
import com.epam.repository.OrderItemRepository;
import com.epam.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

  @Bean
  OrderItemMapper getOrderItemMapper() {
    return new OrderItemMapper();
  }

  @Autowired private OrderItemRepository orderItemRepository;
  @Autowired private OrderItemMapper orderItemMapper;

  @Override
  public OrderItem save(OrderItemDto orderItemDto) {
    return orderItemRepository.save(orderItemMapper.getEntity(orderItemDto));
  }

  @Override
  public List<OrderItem> findByServiceId(long id) {
    return orderItemRepository.findByServiceId(id);
  }
}
