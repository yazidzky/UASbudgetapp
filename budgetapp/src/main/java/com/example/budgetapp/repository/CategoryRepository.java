package com.example.budgetapp.repository;

import com.example.budgetapp.model.Transaction; // Tambahkan ini
import com.example.budgetapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByType(Transaction.TransactionType type);
}