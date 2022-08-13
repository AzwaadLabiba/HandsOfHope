package com.volunteer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.volunteer.models.Transaction;
import com.volunteer.services.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions")
	public String viewTransactionpage(Model model) {
		model.addAttribute("transactionList", transactionService.getAllTransactions());
		return "transactions";
	}
	
	@PostMapping("/addNewTransaction")
	public String saveTransaction(@ModelAttribute("transactions") Transaction transaction){
		//save transaction
		this.transactionService.saveTransaction(transaction);
		return "redirect:/transactions";
	}
	
	@GetMapping("/showtransactionUpdateForm/{id}")
	public String showtransactionUpdateForm(@PathVariable (value = "id") Integer id, Model model) {
		//get transaction
		Transaction transaction = transactionService.getTransactionById(id);
		 
		//set transaction as a model attribute to pre-populate form
		model.addAttribute("transaction", transaction);
		return "transactionUpdateForm";
	}
	
	@GetMapping("/deleteTransaction/{id}")
	public String deleteTransaction(@PathVariable (value = "id") Integer id) {
		this.transactionService.deleteTransactionById(id);
		return "redirect:/transactions";
	}


}
