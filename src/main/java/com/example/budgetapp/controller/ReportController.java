// ReportController.java
package com.example.budgetapp.controller;

import com.example.budgetapp.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/reports")
public class ReportController {

    private final TransactionService transactionService;

    public ReportController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public String getReports(Model model) {
        // Data untuk chart
        List<Map<String, Object>> incomeByCategory = transactionService.getIncomeByCategory();
        List<Map<String, Object>> expenseByCategory = transactionService.getExpenseByCategory();
        
        model.addAttribute("incomeByCategory", incomeByCategory);
        model.addAttribute("expenseByCategory", expenseByCategory);
        model.addAttribute("balance", transactionService.getCurrentBalance());
        
        return "reports/view";
    }
}