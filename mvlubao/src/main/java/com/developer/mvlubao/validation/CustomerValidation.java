package com.developer.mvlubao.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

import com.developer.mvlubao.model.Customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerValidation implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
    	Customer customer = (Customer) target;
    	

		validateCustomerName(customer, target, errors);
		validateCustomerMobile(customer, target, errors);
		validateCustomerEmail(customer, target, errors);
		validateAddress1(customer, target, errors);
	}


	public void validateCustomerName(Customer customer, Object target, Errors errors) {
		//Not null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "CustomerName", "field.required", "Customer Name is required field");
		
		//Exceeds max limit
		if (customer.getCustomerName() != null && customer.getCustomerName().length() > 50) {
            errors.rejectValue("CustomerName", "field.invalid", "Customer Name exceeds allowed limit");
        }	 
	}
	


	public void validateCustomerMobile(Customer customer, Object target, Errors errors) {
		//Not null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "CustomerMobile", "field.required", "Customer Mobile is required field");
		
		//Exceeds max limit
		if (customer.getCustomerMobile() != null && customer.getCustomerMobile().length() > 20) {
            errors.rejectValue("CustomerMobile", "field.invalid", "Customer Mobile exceeds allowed limit");
        }	 
	}
	
	public void validateCustomerEmail(Customer customer, Object target, Errors errors) {
		//Not null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "CustomerEmail", "field.required", "Customer Email is required field");
		
		//Exceeds max limit
		if (customer.getCustomerEmail() != null && customer.getCustomerEmail().length() > 50) {
            errors.rejectValue("CustomerEmail", "field.invalid", "Customer Email exceeds allowed limit");
        }	 
		
		//Email format
		String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	    Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	    if(customer.getCustomerEmail() != null ) {
	    	if (!EMAIL_PATTERN.matcher(customer.getCustomerEmail()).matches()) {
	            errors.rejectValue("CustomerEmail", "field.invalid", "Invalid email format");
	        }
	    }   	    
	}
	
	public void validateAddress1(Customer customer, Object target, Errors errors) {
		//Not null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Address1", "field.required", "Address 1 is required field");
		
		//Exceeds max limit
		if (customer.getAddress1() != null && customer.getAddress1().length() > 100) {
            errors.rejectValue("Address1", "field.invalid", "Address 1 exceeds allowed limit");
        }	 
	}
	
	
	
}
