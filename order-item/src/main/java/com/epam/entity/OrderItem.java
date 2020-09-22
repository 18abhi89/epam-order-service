package com.epam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class OrderItem implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @NotNull
  @Column(name = "product_code")
  public long productCode;

  @Length(min = 3, max = 10)
  @Column(name = "product_name")
  public String productName;

  @NumberFormat(style = Style.NUMBER)
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
