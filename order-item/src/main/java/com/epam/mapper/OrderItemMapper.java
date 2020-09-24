package com.epam.mapper;

import com.epam.entity.OrderItem;
import com.epam.entity.dto.OrderItemDto;

public class OrderItemMapper {

  public OrderItem getEntity(OrderItemDto orderItemDto) {
    OrderItem orderItem = new OrderItem();
    orderItem.setProductName(orderItemDto.getProductName());
    orderItem.setQuantity(orderItemDto.getQuantity());
    return orderItem;
  }

  /*public OrderItemDto getDto(OrderItem order) {
    OrderItemDto orderItemDto = new OrderItemDto();
    return orderItemDto;
  }*/
}
