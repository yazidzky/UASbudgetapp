package com.example.budgetapp.service;

import com.example.budgetapp.dto.TransactionDto;
import com.example.budgetapp.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface TransactionService {
    Transaction createTransaction(TransactionDto transactionDto);
    Transaction updateTransaction(Long id, TransactionDto transactionDto);
    void deleteTransaction(Long id);
    Transaction getTransactionById(Long id);
    List<Transaction> getAllTransactions();
    List<Transaction> getTransactionsByDateRange(LocalDate start, LocalDate end);
    List<Transaction> getTransactionsByType(Transaction.TransactionType type);
    List<Transaction> getTransactionsByCategory(Long categoryId);

    BigDecimal getCurrentBalance();

    // Laporan per kategori
    List<Map<String, Object>> getIncomeByCategory();
    List<Map<String, Object>> getExpenseByCategory();

    // Filter gabungan
    List<Transaction> filterTransactions(String type, LocalDate startDate, LocalDate endDate, Long categoryId);
}
