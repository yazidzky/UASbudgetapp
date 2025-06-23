package com.example.budgetapp.service;

import com.example.budgetapp.dto.TransactionDto;
import com.example.budgetapp.model.Transaction;
import java.time.LocalDate;
import java.util.List;
import java.math.BigDecimal;
import java.util.Map;

public interface TransactionService {
    Transaction createTransaction(TransactionDto transactionDto);
    Transaction updateTransaction(Long id, TransactionDto transactionDto);
    void deleteTransaction(Long id);
    Transaction getTransactionById(Long id);
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsByDateRange(LocalDate start, LocalDate end);
    List<Transaction> getTransactionsByType(Transaction.TransactionType type);
    BigDecimal getCurrentBalance();
    
    // New methods for reports
    List<Map<String, Object>> getIncomeByCategory();
    List<Map<String, Object>> getExpenseByCategory();
}