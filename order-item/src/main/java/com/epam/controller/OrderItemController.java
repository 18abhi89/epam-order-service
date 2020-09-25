package com.epam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.OrderItemDto;
import com.epam.entity.OrderItem;
import com.epam.service.OrderItemService;
import com.epam.service.impl.OrderItemServiceImpl;

@RestController
@RequestMapping("/item")
public class OrderItemController {

  @Bean
  OrderItemService orderItemService() {
    return new OrderItemServiceImpl();
  }

  @Autowired private OrderItemService orderItemService;

  @PostMapping("/items")
  public OrderItem orderItem(@RequestBody @Valid OrderItemDto orderItemDto) {
    return orderItemService.save(orderItemDto);
  }

  @GetMapping(path = "/{id}")
  public List<OrderItem> item(@PathVariable(name = "id") long serviceId) {
    return orderItemService.findByServiceId(serviceId);
  }
}
