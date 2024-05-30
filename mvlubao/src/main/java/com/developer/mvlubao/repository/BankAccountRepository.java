package com.developer.mvlubao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.developer.mvlubao.model.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Integer>{
	
	List<BankAccount> findByCustomerNumber(Integer customerNumber);
	
	@Query(value = "SELECT accountnumber_seq.nextval seqno from dual", nativeQuery = true)
	String getNextBankAccountNumber();
	
	

}
