package com.developer.mvlubao.response;

public class NotFound {
	private String transactionStatusCode;
	private String transactionStatusDescription;
	public NotFound(String transactionStatusCode, String transactionStatusDescription) {
		super();
		this.transactionStatusCode = transactionStatusCode;
		this.transactionStatusDescription = transactionStatusDescription;
	}
	public NotFound() {
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
		return "NotFound [transactionStatusCode=" + transactionStatusCode + ", transactionStatusDescription="
				+ transactionStatusDescription + "]";
	}
	
	
	
}
