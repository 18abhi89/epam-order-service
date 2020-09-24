package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.entity.OrderService;

public interface OrderServiceRepository extends JpaRepository<OrderService, Long> {

  OrderService findById(long id);
}
