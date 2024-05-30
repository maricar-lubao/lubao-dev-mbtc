package com.developer.mvlubao.response;

public class Created {
	private Integer customerNumber;
	private String transactionStatusCode;
	private String transactionStatusDescription;
	
	public Created(Integer customerNumber, String transactionStatusCode, String transactionStatusDescription) {
		super();
		this.customerNumber = customerNumber;
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}
	
	

	public Created() {
		super();
	}



	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
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
		return "Created [customerNumber=" + customerNumber + ", transactionStatusCode=" + transactionStatusCode
				+ ", transactionStatusDescription=" + transactionStatusDescription + "]";
	}
	
	

}
