package com.developer.mvlubao.controller;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;

import com.developer.mvlubao.dto.CreateRequest;
import com.developer.mvlubao.dto.Savings;
import com.developer.mvlubao.model.BankAccount;
import com.developer.mvlubao.model.Customer;
import com.developer.mvlubao.service.BankAccountService;
import com.developer.mvlubao.service.CustomerService;
import com.developer.mvlubao.validation.BankAccountValidation;
import com.developer.mvlubao.validation.CustomerValidation;
import com.fasterxml.jackson.core.JsonParseException;
import com.developer.mvlubao.response.BadRequest;
import com.developer.mvlubao.response.Created;
import com.developer.mvlubao.response.CustomerFound;
import com.developer.mvlubao.response.NotFound;

@RestController
@Validated
@RequestMapping("/api/v1")
public class CustomerController {
	@Autowired
    private CustomerService customerService;
	
	@Autowired
    private BankAccountService bankAccountService;
	
    @Autowired
    private CustomerValidation customerValidation;
    
    @Autowired
    private BankAccountValidation bankAccountValidation;
    
	@PostMapping("/account")
	public Object createCustomer(@Valid @RequestBody CreateRequest createRequest, BindingResult bindingResult) {
		///// Customer ////
		Customer customer = new Customer();
        customer.setCustomerName(createRequest.getCustomerName());
        customer.setCustomerMobile(createRequest.getCustomerMobile());
        customer.setCustomerEmail(createRequest.getCustomerEmail());
        customer.setAddress1(createRequest.getAddress1());
        customer.setAddress2(createRequest.getAddress2());
		
		customerValidation.validate(customer, bindingResult);
		
		if (bindingResult.hasErrors()) {
			for (String field : bindingResult.getFieldErrors().stream().map(error -> error.getField()).distinct().toArray(String[]::new)) {   
				for (ObjectError error : bindingResult.getFieldErrors(field)) {
					return createdBadRequest(error.getDefaultMessage());
                }
            }  
        }
		Customer newCustomer = customerService.createCustomer(customer);
		
		///// Bank Account ////
		BankAccount bankAccount = new BankAccount();
		bankAccount.setCustomerNumber(newCustomer.getCustomerNumber());
		bankAccount.setAccountType(createRequest.getAccountType());
		bankAccount.setAvailableBalance(0.00);
		bankAccount.setAccountNumber(bankAccountService.getNextAccountNumber());
		
		bankAccountValidation.validate(bankAccount, bindingResult);
		
		if (bindingResult.hasErrors()) {
			for (String field : bindingResult.getFieldErrors().stream().map(error -> error.getField()).distinct().toArray(String[]::new)) {   
				System.out.println("Field: " + field);
				for (ObjectError error : bindingResult.getFieldErrors(field)) {
					System.out.println(error.getDefaultMessage());
					customerService.deleteCustomer(newCustomer);
					return createdBadRequest(error.getDefaultMessage());
                }
            }  
        }
		bankAccountService.createBankAccount(bankAccount);
		
        return createdSuccess(newCustomer.getCustomerNumber());
	}
	
	
	@GetMapping("/account/{customerNumber}")
	public Object getCustomer(@PathVariable("customerNumber") Integer customerNumber) {		
		Customer selectedCustomer = customerService.findCustomer(customerNumber);
		if (selectedCustomer==null) {
			return notFound("Customer not found");
		}
		return customerFound(selectedCustomer);
	}
	

	
	
	public Created createdSuccess (Integer customerId) {
		Created response = new Created();
        response.setCustomerNumber(customerId);
        response.setTransactionStatusCode("201");
        response.setTransactionStatusDescription("Customer account created");
        
        return response;
	}
	
	public BadRequest createdBadRequest(String statDescription) {
		BadRequest errorMsg = new BadRequest();
		errorMsg.setTransactionStatusCode("400");
        errorMsg.setTransactionStatusDescription(statDescription);
        
        return errorMsg;
	}
	
	public NotFound notFound(String statDescription) {
		NotFound errorMsg = new NotFound();
		errorMsg.setTransactionStatusCode("401");
		errorMsg.setTransactionStatusDescription(statDescription);
		return errorMsg;
	}
	
	public CustomerFound customerFound(Customer customer) {
		CustomerFound customerDtl = new CustomerFound();
		customerDtl.setCustomerNumber(customer.getCustomerNumber());
		customerDtl.setCustomerName(customer.getCustomerName());
		customerDtl.setCustomerMobile(customer.getCustomerMobile());
		customerDtl.setCustomerEmail(customer.getCustomerEmail());
		customerDtl.setAddress1(customer.getAddress1());
		customerDtl.setAddress2(customer.getAddress2());
		
		List<Savings> banks = new ArrayList<>();
		List<BankAccount> bankAccounts = bankAccountService.getBanks(customer.getCustomerNumber());
		
		
		for (int i = 0; i < bankAccounts.size(); i++) {
			BigDecimal bal = new BigDecimal(bankAccounts.get(i).getAvailableBalance());
						
			Savings savingsDtl = new Savings();
			savingsDtl.setAccountNumber(bankAccounts.get(i).getAccountNumber());
			savingsDtl.setAccountType(bankAccounts.get(i).getAccountType().equalsIgnoreCase("S")?"Savings":"Checking");
			savingsDtl.setAvailableBalance(bal);
			banks.add(savingsDtl);
		}
		
		customerDtl.setSavingsList(banks);
		customerDtl.setTransactionStatusCode("302");
		customerDtl.setTransactionStatusDescription("Customer account found");
			
		
		
		
		return customerDtl;
		
	}
	
	
	
	@ControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(JsonParseException.class)
        @ResponseBody
        public BadRequest handleJsonParseException(JsonParseException ex) {
            return createdBadRequest("Invalid JSON");
        }
    }
	
	

}
