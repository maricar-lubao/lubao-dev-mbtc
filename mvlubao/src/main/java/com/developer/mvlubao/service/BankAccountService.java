package com.developer.mvlubao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.mvlubao.model.BankAccount;
import com.developer.mvlubao.repository.BankAccountRepository;

@Service
public class BankAccountService {
	private final BankAccountRepository bankAccountRepository;
	
    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    
    public BankAccount createBankAccount(BankAccount bankAccount) {
    	return bankAccountRepository.save(bankAccount);
    }
    
    public Integer getNextAccountNumber() {
    	return Integer.parseInt(bankAccountRepository.getNextBankAccountNumber());
    }
    
    public List<BankAccount> getBanks(Integer customerNumber) {
    	return bankAccountRepository.findByCustomerNumber(customerNumber);
    }
    
  
	
}
