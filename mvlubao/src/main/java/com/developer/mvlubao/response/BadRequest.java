package com.developer.mvlubao.response;

public class BadRequest {
	private String transactionStatusCode;
	private String transactionStatusDescription;
	public BadRequest(String transactionStatusCode, String transactionStatusDescription) {
		super();
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}
	public BadRequest() {
		super();
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
		return "BadRequest [transactionStatusCode=" + transactionStatusCode + ", transactionStatusDescription="
				+ transactionStatusDescription + "]";
	}
	
	
	
	
}
