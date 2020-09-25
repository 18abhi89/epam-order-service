package com.epam.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.OrderDto;
import com.epam.entity.Order;
import com.epam.service.OrderService;
import com.epam.service.impl.OrderServiceImpl;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class OrderController {

  @Bean
  OrderService getOrderService() {
    return new OrderServiceImpl();
  }

  @Autowired private OrderService orderService;

  @PostMapping("/orders")
  public Order order(@RequestBody @Valid OrderDto orderDto) {
    return orderService.save(orderDto);
  }

  @GetMapping("/order/{id}")
  public Order orderInfo(@PathVariable(name = "id") long serviceId) {
    return orderService.findById(serviceId);
  }
}
