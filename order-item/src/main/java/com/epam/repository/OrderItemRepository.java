package com.epam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

  List<OrderItem> findByServiceId(long serviceId);
}
