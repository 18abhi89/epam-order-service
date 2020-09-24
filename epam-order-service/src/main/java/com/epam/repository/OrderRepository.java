package com.epam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

  Order findById(long id);
}
