package com.epam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.epam.dto.OrderDto;
import com.epam.entity.Order;
import com.epam.entity.OrderItem;
import com.epam.exception.OrderNotFoundException;
import com.epam.feignClient.OrderFeignClient;
import com.epam.mapper.OrderMapper;
import com.epam.repository.OrderRepository;
import com.epam.service.OrderService;

@Service
@EnableFeignClients(basePackages = {"com.epam.*"})
public class OrderServiceImpl implements OrderService {

  @Bean
  OrderMapper getOrderMapper() {
    return new OrderMapper();
  }

  @Autowired private OrderRepository orderRepository;
  @Autowired private OrderFeignClient orderFeignClient;
  @Autowired private OrderMapper orderMapper;

  @Override
  public Order save(OrderDto orderDto) {
    Order savedOrder = orderRepository.save(orderMapper.getEntity(orderDto));
    List<OrderItem> items = savedOrder.getItems();
    for (OrderItem item : items) {
      item.setServiceId(savedOrder.getId());
      orderFeignClient.item(item);
    }
    return savedOrder;
  }

  @Override
  public Order findById(long id) {
    Order order = orderRepository.findById(id);
    if (null == order) {
      throw new OrderNotFoundException("order could not be found!");
    }
    List<OrderItem> items = orderFeignClient.items(id);
    order.setItems(items);
    return order;
  }
}
