package com.epam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public long productCode;

  public String productName;

  public int quantity;

  public long serviceId;

  public long getServiceId() {
    return serviceId;
  }

  public void setServiceId(long serviceId) {
    this.serviceId = serviceId;
  }

  public long getProductCode() {
    return productCode;
  }

  public void setProductCode(long productCode) {
    this.productCode = productCode;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public OrderItem() {}

  public OrderItem(long code, String name, int quantity) {
    this.productCode = code;
    this.productName = name;
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "OrderItem [productCode="
        + productCode
        + ", productName="
        + productName
        + ", quantity="
        + quantity
        + "]";
  }
}
