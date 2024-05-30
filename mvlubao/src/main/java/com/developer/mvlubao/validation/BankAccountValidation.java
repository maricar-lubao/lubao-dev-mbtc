package com.developer.mvlubao.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.developer.mvlubao.model.BankAccount;

@Component
public class BankAccountValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return BankAccount.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BankAccount bankAccount = (BankAccount) target;
		
		validateAccountType(bankAccount, target, errors);
		
	}
	
	public void validateAccountType(BankAccount bankAccount, Object target, Errors errors) {
		//Not null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "AccountType", "field.required", "Account Type is required field");
		
		//Exceeds max limit
		if (bankAccount.getAccountType()!= null && bankAccount.getAccountType().length() > 1) {
	        errors.rejectValue("AccountType", "field.invalid", "Account Type exceeds allowed limit");
	    }	
	
		//Enum
		if(bankAccount.getAccountType()!=null) {
			if(!bankAccount.getAccountType().equalsIgnoreCase("S") && !bankAccount.getAccountType().equalsIgnoreCase("C")) {
				errors.rejectValue("AccountType", "field.invalid", "Account type is incorrect");
			}
		}
	}

}
