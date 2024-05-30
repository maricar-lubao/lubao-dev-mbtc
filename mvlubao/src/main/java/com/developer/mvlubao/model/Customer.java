package com.developer.mvlubao.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerNumber;
	private String customerName;
	private String customerMobile;
	private String customerEmail;
	private String address1;
	private String address2;
	
	public Customer(Integer customerNumber, String customerName, String customerMobile, String customerEmail,
			String address1, String address2) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.address1 = address1;
		this.address2 = address2;
	}

	public Customer() {
		super();
	}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", customerName=" + customerName + ", customerMobile="
				+ customerMobile + ", customerEmail=" + customerEmail + ", address1=" + address1 + ", address2="
				+ address2 + "]";
	}
	
	
	

	
	
	
}
