package com.example.budgetapp;

import com.example.budgetapp.model.Category;
import com.example.budgetapp.model.Transaction;
import com.example.budgetapp.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BudgetappApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudgetappApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CategoryRepository categoryRepository) {
        return _ -> {  // Using underscore for unused parameter
            // Only insert data if database is empty
            if (categoryRepository.count() == 0) {
                // Income Categories
                categoryRepository.save(createCategory("Gaji", "Pendapatan bulanan", Transaction.TransactionType.INCOME));
                categoryRepository.save(createCategory("Bonus", "Tambahan penghasilan", Transaction.TransactionType.INCOME));
                categoryRepository.save(createCategory("Investasi", "Hasil investasi", Transaction.TransactionType.INCOME));
                
                // Expense Categories
                categoryRepository.save(createCategory("Makanan", "Pengeluaran untuk makanan", Transaction.TransactionType.EXPENSE));
                categoryRepository.save(createCategory("Transportasi", "Biaya transport harian", Transaction.TransactionType.EXPENSE));
                categoryRepository.save(createCategory("Hiburan", "Pengeluaran hiburan", Transaction.TransactionType.EXPENSE));
                categoryRepository.save(createCategory("Tagihan", "Pembayaran rutin", Transaction.TransactionType.EXPENSE));
                
                System.out.println("Initial sample categories added successfully!");
            }
        };
    }

    private Category createCategory(String name, String description, Transaction.TransactionType type) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setType(type);
        return category;
    }
}