package com.volunteer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volunteer.models.Transaction;
import com.volunteer.repositories.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Transaction> getAllTransactions(){
		return transactionRepository.findAll();
	}
	
	public void saveTransaction(Transaction transaction){
		this.transactionRepository.save(transaction);
	}
	
	public Transaction getTransactionById(Integer id){
		Optional<Transaction> optional = transactionRepository.findById(id);
		Transaction transaction = null;
		
		if(optional.isPresent()) {
			transaction = optional.get();
		}else {
			throw new RuntimeException(" Transaction not found for id: "+id);
		}
		return transaction;
	}
	
	public void deleteTransactionById(Integer id){
		this.transactionRepository.deleteById(id);
	}


}
