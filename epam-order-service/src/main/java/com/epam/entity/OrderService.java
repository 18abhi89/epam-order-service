package com.epam.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "order_service")
@SuppressWarnings("unused")
public class OrderService implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @NotNull
  private long id;

  @Column(name = "cust_name")
  private String customerName;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  @Column(name = "order_date")
  private Date orderDate;

  @Column(name = "shipping_address")
  private String shippingAddress;

  @Transient
  private List<OrderItem> items;

  @Column(name = "total_amount")
  @NotNull
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

  public List<OrderItem> getItems() {
    return items;
  }

  public void setItems(List<OrderItem> item) {
    this.items = item;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public OrderService() {}

  public OrderService(
      String customerName,
      Date orderDate,
      String shippingAddress,
      List<OrderItem> items,
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
