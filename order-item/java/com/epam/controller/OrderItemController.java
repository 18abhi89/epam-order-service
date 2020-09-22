package com.epam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.OrderItem;
import com.epam.repository.OrderItemRepository;

@RestController
@RequestMapping("/item")
public class OrderItemController {

  @Autowired private OrderItemRepository orderItemRepository;

  @PostMapping("/items")
    public OrderItem orderItem(@RequestBody OrderItem orderItem) {
      return orderItemRepository.save(orderItem);
    }
  
  @GetMapping(path = "/{id}")
  public List<OrderItem> item(@PathVariable(name = "id") long serviceId) {
    return orderItemRepository.findByServiceId(serviceId);
  }

}
