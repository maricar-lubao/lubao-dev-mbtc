package com.developer.mvlubao.dto;

import java.math.BigDecimal;

public class Savings {
	private Integer accountNumber;
	private String accountType;
	private BigDecimal availableBalance;
	
	public Savings(Integer accountNumber, String accountType, BigDecimal availableBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
	}

	public Savings() {
		super();
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	@Override
	public String toString() {
		return "Savings [accountNumber=" + accountNumber + ", accountType=" + accountType + ", availableBalance="
				+ availableBalance + "]";
	}
	
	
	
}
