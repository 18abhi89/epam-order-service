package com.epam.mapper;

import com.epam.dto.OrderItemDto;
import com.epam.entity.OrderItem;

public class OrderItemMapper {

  public OrderItem getEntity(OrderItemDto orderItemDto) {
    OrderItem orderItem = new OrderItem();
    orderItem.setProductName(orderItemDto.getProductName());
    orderItem.setQuantity(orderItemDto.getQuantity());
    orderItem.setServiceId(orderItemDto.getServiceId());
    return orderItem;
  }

  /*public OrderItemDto getDto(OrderItem order) {
    OrderItemDto orderItemDto = new OrderItemDto();
    return orderItemDto;
  }*/
}
