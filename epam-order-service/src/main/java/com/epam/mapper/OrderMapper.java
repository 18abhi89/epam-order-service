package com.epam.mapper;

import java.util.stream.Collectors;

import com.epam.dto.OrderDto;
import com.epam.dto.OrderItemDto;
import com.epam.entity.Order;
import com.epam.entity.OrderItem;

public class OrderMapper {

  public Order getEntity(OrderDto orderDto) {
    Order order = new Order();
    order.setCustomerName(orderDto.getCustomerName());
    order.setItems(
        orderDto.getItems().stream().map(this::convertToOrderItem).collect(Collectors.toList()));
    order.setOrderDate(orderDto.getOrderDate());
    order.setShippingAddress(orderDto.getShippingAddress());
    order.setTotalAmount(orderDto.getTotalAmount());
    return order;
  }

  public OrderDto getDto(Order order) {
    OrderDto orderDto = new OrderDto();
    orderDto.setCustomerName(order.getCustomerName());
    orderDto.setItems(
        order.getItems().stream().map(this::convertToOrderItemDto).collect(Collectors.toList()));
    order.setOrderDate(orderDto.getOrderDate());
    orderDto.setOrderDate(order.getOrderDate());
    orderDto.setShippingAddress(order.getShippingAddress());
    orderDto.setTotalAmount(order.getTotalAmount());
    return orderDto;
  }

  private OrderItem convertToOrderItem(OrderItemDto dto) {
    OrderItem item = new OrderItem();
    item.setProductName(dto.getProductName());
    item.setQuantity(dto.getQuantity());
    return item;
  }

  private OrderItemDto convertToOrderItemDto(OrderItem item) {
    OrderItemDto dto = new OrderItemDto();
    dto.setProductName(item.getProductName());
    dto.setQuantity(item.getQuantity());
    return dto;
  }
}
