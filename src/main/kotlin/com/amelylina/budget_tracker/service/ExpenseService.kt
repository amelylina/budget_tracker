package com.amelylina.budget_tracker.service

import com.amelylina.budget_tracker.model.Expense
import com.amelylina.budget_tracker.repository.ExpenseRepository
import org.springframework.stereotype.Service

@Service
class ExpenseService(private val expenseRepository: ExpenseRepository) {

    fun getAllExpenses(): List<Expense> {
        return expenseRepository.findAll()
    }

    fun addExpense(expense: Expense): Expense {
        return expenseRepository.save(expense)
    }

    fun getExpenseById(id: Long): Expense? {
        return expenseRepository.findById(id).orElse(null)
    }

    fun deleteExpense(id: Long) {
        expenseRepository.deleteById(id)
    }
}
