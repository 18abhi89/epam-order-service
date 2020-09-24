package com.epam.controller;

import java.util.List;

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
import com.epam.exception.OrderNotFoundException;
import com.epam.feign.OrderFeignClient;
import com.epam.repository.OrderServiceRepository;

@RestController
@EnableFeignClients
public class OrderController {

  @Autowired private OrderFeignClient feignClient;
  @Autowired private OrderServiceRepository orderServiceRepository;

  @PostMapping("/orders") 
  public Order order(@RequestBody Order orderService) {
    Order savedService = orderServiceRepository.save(orderService);
    List<OrderItem> items = orderService.getItems();
    for (OrderItem item : items) {
      item.setServiceId(savedService.getId());
      feignClient.item(item);
    }
    return savedService;
  }
  
  @GetMapping("/order/{id}")
  public Order orderInfo(@PathVariable(name = "id") long serviceId) {
    Order service = orderServiceRepository.findById(serviceId);
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
