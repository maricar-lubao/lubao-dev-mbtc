package com.developer.mvlubao.dto;

public class CreateRequest {
	private String customerName;
	private String customerMobile;
	private String customerEmail;
	private String address1;
	private String address2;
	private String accountType;
	
	public CreateRequest(String customerName, String customerMobile, String customerEmail, String address1,
			String address2, String accountType) {
		super();
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.address1 = address1;
		this.address2 = address2;
		this.accountType = accountType;
	}

	public CreateRequest() {
		super();
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

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "CreateRequest [customerName=" + customerName + ", customerMobile=" + customerMobile + ", customerEmail="
				+ customerEmail + ", address1=" + address1 + ", address2=" + address2 + ", accountType=" + accountType
				+ "]";
	}
	
	
	
	
}
