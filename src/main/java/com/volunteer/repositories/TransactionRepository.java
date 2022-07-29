package com.volunteer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volunteer.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
