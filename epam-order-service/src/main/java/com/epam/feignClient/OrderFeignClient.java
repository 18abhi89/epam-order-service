package com.epam.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.epam.entity.OrderItem;

@FeignClient(value = "order-item-service", url = "http://localhost:8002/item")
public interface OrderFeignClient {

  @GetMapping("/{id}")
  List<OrderItem> items(@PathVariable(name = "id") long id);

  @PostMapping("/items")
  OrderItem item(@RequestBody OrderItem orderItem);
}
