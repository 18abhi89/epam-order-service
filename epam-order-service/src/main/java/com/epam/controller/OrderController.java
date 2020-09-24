package com.epam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.Order;
import com.epam.entity.OrderItem;
import com.epam.entity.dto.OrderDto;
import com.epam.exception.OrderNotFoundException;
import com.epam.feignClient.OrderFeignClient;
import com.epam.service.OrderService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableFeignClients
@EnableSwagger2
public class OrderController {

  @Autowired private OrderFeignClient feignClient;
  @Autowired private OrderService orderService;

  @PostMapping("/orders") 
  public Order order(@RequestBody @Valid OrderDto orderDto) {
    Order savedOrder = orderService.save(orderDto);
    List<OrderItem> items = savedOrder.getItems();
    for (OrderItem item : items) {
      item.setServiceId(savedOrder.getId());
      feignClient.item(item);
    }
    return savedOrder;
  }
  
  @GetMapping("/order/{id}")
  public Order orderInfo(@PathVariable(name = "id") long serviceId) {
    Order service = orderService.findById(serviceId);
    if (null == service) {
      throw new OrderNotFoundException("order could not be found!");
    }
    List<OrderItem> items = feignClient.items(serviceId);
    service.setItems(items);
    return service;
  }

  public static void main(String[] args) {
    SpringApplication.run(OrderController.class, args);
  }
}
