package com.developer.mvlubao.response;

import java.util.List;

import com.developer.mvlubao.dto.Savings;

public class CustomerFound {
	private Integer customerNumber;
	private String customerName;
	private String customerMobile;
	private String customerEmail;
	private String address1;
	private String address2;
	private List<Savings> savingsList;
	private String transactionStatusCode;
	private String transactionStatusDescription;
	public CustomerFound(Integer customerNumber, String customerName, String customerMobile, String customerEmail,
			String address1, String address2, List<Savings> savingsList, String transactionStatusCode,
			String transactionStatusDescription) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.address1 = address1;
		this.address2 = address2;
		this.savingsList = savingsList;
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}
	public CustomerFound() {
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
	public List<Savings> getSavingsList() {
		return savingsList;
	}
	public void setSavingsList(List<Savings> savingsList) {
		this.savingsList = savingsList;
	}
	public String getTransactionStatusCode() {
		return transactionStatusCode;
	}
	public void setTransactionStatusCode(String transactionStatusCode) {
		this.transactionStatusCode = transactionStatusCode;
	}
	public String getTransactionStatusDescription() {
		return transactionStatusDescription;
	}
	public void setTransactionStatusDescription(String transactionStatusDescription) {
		this.transactionStatusDescription = transactionStatusDescription;
	}
	@Override
	public String toString() {
		return "CustomerFound [customerNumber=" + customerNumber + ", customerName=" + customerName
				+ ", customerMobile=" + customerMobile + ", customerEmail=" + customerEmail + ", address1=" + address1
				+ ", address2=" + address2 + ", savingsList=" + savingsList + ", transactionStatusCode="
				+ transactionStatusCode + ", transactionStatusDescription=" + transactionStatusDescription + "]";
	}
	
	
	
}
