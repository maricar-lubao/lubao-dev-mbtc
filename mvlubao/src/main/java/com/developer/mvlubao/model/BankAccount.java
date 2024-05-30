package com.developer.mvlubao.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANKACCOUNT")
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankAcctId;
	private Integer customerNumber;
	@Column(name = "account_number")
	private Integer accountNumber;
	private String accountType;
	private Double availableBalance;
	
	
	public BankAccount(Integer bankAcctId, Integer customerNumber, Integer accountNumber, String accountType,
			Double availableBalance) {
		super();
		this.bankAcctId = bankAcctId;
		this.customerNumber = customerNumber;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
	}
	public BankAccount() {
		super();
	}
	public Integer getBankAcctId() {
		return bankAcctId;
	}
	public void setBankAcctId(Integer bankAcctId) {
		this.bankAcctId = bankAcctId;
	}
	public Integer getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
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
	public Double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}
	@Override
	public String toString() {
		return "BankAccount [bankAcctId=" + bankAcctId + ", customerNumber=" + customerNumber + ", accountNumber="
				+ accountNumber + ", accountType=" + accountType + ", availableBalance=" + availableBalance + "]";
	}
	
	
}