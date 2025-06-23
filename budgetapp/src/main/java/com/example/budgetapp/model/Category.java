package com.example.budgetapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @Column(nullable = false)
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Transaction.TransactionType type;

    // Tambahkan konstruktor tanpa id (untuk create new)
    public Category(String name, String description, Transaction.TransactionType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }
}