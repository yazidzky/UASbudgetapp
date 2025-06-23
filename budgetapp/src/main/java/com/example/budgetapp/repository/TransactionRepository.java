package com.example.budgetapp.repository;

import com.example.budgetapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByDateBetween(LocalDate start, LocalDate end);
    List<Transaction> findByType(Transaction.TransactionType type);
    List<Transaction> findByCategoryId(Long categoryId);
}