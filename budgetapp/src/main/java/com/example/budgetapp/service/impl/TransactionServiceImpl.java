package com.example.budgetapp.service.impl;

import com.example.budgetapp.dto.TransactionDto;
import com.example.budgetapp.exception.ResourceNotFoundException;
import com.example.budgetapp.model.Transaction;
import com.example.budgetapp.model.Category;
import com.example.budgetapp.repository.TransactionRepository;
import com.example.budgetapp.repository.CategoryRepository;
import com.example.budgetapp.service.TransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Transaction createTransaction(TransactionDto transactionDto) {
        Category category = categoryRepository.findById(transactionDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Kategori tidak ditemukan"));

        Transaction transaction = new Transaction();
        transaction.setDescription(transactionDto.getDescription());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setDate(transactionDto.getDate());
        transaction.setType(transactionDto.getType());
        transaction.setCategory(category);

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Long id, TransactionDto transactionDto) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaksi tidak ditemukan"));

        Category category = categoryRepository.findById(transactionDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Kategori tidak ditemukan"));

        transaction.setDescription(transactionDto.getDescription());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setDate(transactionDto.getDate());
        transaction.setType(transactionDto.getType());
        transaction.setCategory(category);

        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaksi tidak ditemukan"));
        transactionRepository.delete(transaction);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaksi tidak ditemukan"));
    }

    @Override
    public List<Transaction> getTransactionsByCategory(Long categoryId) {
        return transactionRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> getTransactionsByDateRange(LocalDate start, LocalDate end) {
        return transactionRepository.findByDateBetween(start, end);
    }

    @Override
    public List<Transaction> getTransactionsByType(Transaction.TransactionType type) {
        return transactionRepository.findByType(type);
    }

    @Override
    public BigDecimal getCurrentBalance() {
        BigDecimal income = transactionRepository.findByType(Transaction.TransactionType.INCOME)
                .stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal expense = transactionRepository.findByType(Transaction.TransactionType.EXPENSE)
                .stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return income.subtract(expense);
    }

    @Override
    public List<Map<String, Object>> getIncomeByCategory() {
        return transactionRepository.findByType(Transaction.TransactionType.INCOME)
                .stream()
                .collect(Collectors.groupingBy(
                        t -> t.getCategory().getName(),
                        Collectors.reducing(BigDecimal.ZERO, Transaction::getAmount, BigDecimal::add)
                ))
                .entrySet()
                .stream()
                .map(e -> {
                    Map<String, Object> result = new HashMap<>();
                    result.put("category", e.getKey());
                    result.put("amount", e.getValue());
                    return result;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> getExpenseByCategory() {
        return transactionRepository.findByType(Transaction.TransactionType.EXPENSE)
                .stream()
                .collect(Collectors.groupingBy(
                        t -> t.getCategory().getName(),
                        Collectors.reducing(BigDecimal.ZERO, Transaction::getAmount, BigDecimal::add)
                ))
                .entrySet()
                .stream()
                .map(e -> {
                    Map<String, Object> result = new HashMap<>();
                    result.put("category", e.getKey());
                    result.put("amount", e.getValue());
                    return result;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> filterTransactions(String type, LocalDate startDate, LocalDate endDate, Long categoryId) {
        return transactionRepository.findAll()
                .stream()
                .filter(t -> (type == null || type.isEmpty() || t.getType().name().equals(type)))
                .filter(t -> (startDate == null || !t.getDate().isBefore(startDate)))
                .filter(t -> (endDate == null || !t.getDate().isAfter(endDate)))
                .filter(t -> (categoryId == null || (t.getCategory() != null && t.getCategory().getId().equals(categoryId))))
                .collect(Collectors.toList());
    }
}
