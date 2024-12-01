package com.amelylina.budget_tracker.model

import jakarta.persistence.*

@Entity
data class Expense(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val amount: Double,
    val description: String,
    val category: String,
    val date: String
)