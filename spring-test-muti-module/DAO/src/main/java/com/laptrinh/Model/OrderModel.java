package com.laptrinh.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class OrderModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss" )
	Date orderDate = new Date();

	@NotEmpty(message = "Vui lòng nhập địa chỉ")
	String address;
	Double amount;
	String description;
	Integer status;

	





	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	@ManyToOne
	@JoinColumn(name = "customerId")
	CustomerModel customerModel;

	@OneToMany(mappedBy = "orderModel", fetch = FetchType.EAGER)
	List<OrderDetailModel> orderDetailModels;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CustomerModel getCustomer() {
		return customerModel;
	}

	public void setCustomer(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}

	public List<OrderDetailModel> getOrderDetails() {
		return orderDetailModels;
	}

	public void setOrderDetails(List<OrderDetailModel> orderDetailModels) {
		this.orderDetailModels = orderDetailModels;
	}

	public OrderModel() {

	}
}
