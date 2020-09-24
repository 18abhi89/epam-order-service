package com.epam.entity.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderDto implements Serializable {
  private static final long serialVersionUID = 1L;

  private long id;

  private String customerName;

  private Date orderDate;

  private String shippingAddress;

  private List<OrderItemDto> items;

  private Double totalAmount;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public String getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public List<OrderItemDto> getItems() {
    return items;
  }

  public void setItems(List<OrderItemDto> item) {
    this.items = item;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public OrderDto() {}

  public OrderDto(
      String customerName,
      Date orderDate,
      String shippingAddress,
      List<OrderItemDto> items,
      Double totalAmount) {
    super();
    this.customerName = customerName;
    this.orderDate = orderDate;
    this.shippingAddress = shippingAddress;
    this.items = items;
    this.totalAmount = totalAmount;
  }

  @Override
  public String toString() {
    return "OrderService [customerName="
        + customerName
        + ", orderDate="
        + orderDate
        + ", shippingAddress="
        + shippingAddress
        + ", items="
        + items
        + ", totalAmount="
        + totalAmount
        + "]";
  }
}
