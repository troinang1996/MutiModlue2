package com.laptrinh.Model;

import javax.persistence.*;

@Entity @Table(name="OrderDetails")
public class OrderDetailModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	Double unitPrice;
	Integer quantity;
	Double discount;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	OrderModel orderModel;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	ProductModel product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public OrderModel getOrder() {
		return orderModel;
	}

	public void setOrder(OrderModel orderModel) {
		this.orderModel = orderModel;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}
}
