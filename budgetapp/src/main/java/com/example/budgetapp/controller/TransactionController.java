package com.example.budgetapp.controller;

import com.example.budgetapp.dto.TransactionDto;
import com.example.budgetapp.model.Transaction;
import com.example.budgetapp.model.Category;
import com.example.budgetapp.service.TransactionService;
import com.example.budgetapp.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final CategoryRepository categoryRepository;

    public TransactionController(TransactionService transactionService, 
                               CategoryRepository categoryRepository) {
        this.transactionService = transactionService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public String getAllTransactions(Model model) {
        List<Transaction> transactions = transactionService.getAllTransactions();
        BigDecimal balance = transactionService.getCurrentBalance();
        List<Category> categories = categoryRepository.findAll();
        
        model.addAttribute("transactions", transactions);
        model.addAttribute("balance", balance);
        model.addAttribute("transactionDto", new TransactionDto());
        model.addAttribute("categories", categories);
        
        return "transactions/list";
    }

    @PostMapping
    public String createTransaction(@ModelAttribute TransactionDto transactionDto) {
        transactionService.createTransaction(transactionDto);
        return "redirect:/transactions";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Transaction transaction = transactionService.getTransactionById(id);
        BigDecimal balance = transactionService.getCurrentBalance();
        List<Category> categories = categoryRepository.findAll();
        
        // Convert Transaction to TransactionDto
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setDescription(transaction.getDescription());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setDate(transaction.getDate());
        transactionDto.setType(transaction.getType());
        transactionDto.setCategoryId(transaction.getCategory() != null ? transaction.getCategory().getId() : null);
        
        model.addAttribute("transactionDto", transactionDto);  // Changed from "transaction" to "transactionDto"
        model.addAttribute("balance", balance);
        model.addAttribute("categories", categories);
        
        return "transactions/edit";
    }

    @PostMapping("/update/{id}")
    public String updateTransaction(@PathVariable Long id, @ModelAttribute TransactionDto transactionDto) {
        transactionService.updateTransaction(id, transactionDto);
        return "redirect:/transactions";
    }

    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "redirect:/transactions";
    }

    @GetMapping("/filter")
    public String filterTransactions(@RequestParam(required = false) String type,
                                    @RequestParam(required = false) String startDate,
                                    @RequestParam(required = false) String endDate,
                                    Model model) {
        List<Transaction> transactions;
        BigDecimal balance = transactionService.getCurrentBalance();
        List<Category> categories = categoryRepository.findAll();
        
        if (type != null && !type.isEmpty()) {
            Transaction.TransactionType transactionType = Transaction.TransactionType.valueOf(type);
            transactions = transactionService.getTransactionsByType(transactionType);
        } else if (startDate != null && endDate != null && !startDate.isEmpty() && !endDate.isEmpty()) {
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            transactions = transactionService.getTransactionsByDateRange(start, end);
        } else {
            transactions = transactionService.getAllTransactions();
        }
        
        model.addAttribute("transactions", transactions);
        model.addAttribute("balance", balance);
        model.addAttribute("transactionDto", new TransactionDto());
        model.addAttribute("categories", categories);
        
        return "transactions/list";
    }
}