package com.amelylina.budget_tracker.repository

import com.amelylina.budget_tracker.model.Expense
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExpenseRepository : JpaRepository<Expense, Long> {
    // Additional query methods can be added here if needed
}
