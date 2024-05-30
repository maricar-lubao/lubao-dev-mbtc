package com.developer.mvlubao.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.mvlubao.model.Customer;
import com.developer.mvlubao.repository.CustomerRepository;

@Service
public class CustomerService {
	
   private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public Customer createCustomer(Customer customer) {
    	return customerRepository.save(customer);
    }
    
    public void deleteCustomer(Customer customer) {
    	customerRepository.delete(customer);
    }
    
    public Customer findCustomer(Integer customerNumber) {
    	return customerRepository.findById(customerNumber).orElse(null);
    }
    
    
}
