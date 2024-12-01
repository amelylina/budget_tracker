package com.amelylina.budget_tracker.controller

import com.amelylina.budget_tracker.model.Expense
import com.amelylina.budget_tracker.service.ExpenseService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/expenses")
class ExpenseController(private val expenseService: ExpenseService) {

    @GetMapping
    fun getAllExpenses(): List<Expense> {
        return expenseService.getAllExpenses()
    }

    @PostMapping
    fun addExpense(@RequestBody expense: Expense): ResponseEntity<Expense> {
        val savedExpense = expenseService.addExpense(expense)
        return ResponseEntity(savedExpense, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getExpenseById(@PathVariable id: Long): ResponseEntity<Expense> {
        val expense = expenseService.getExpenseById(id)
        return if (expense != null) {
            ResponseEntity(expense, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteExpense(@PathVariable id: Long): ResponseEntity<Void> {
        expenseService.deleteExpense(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
