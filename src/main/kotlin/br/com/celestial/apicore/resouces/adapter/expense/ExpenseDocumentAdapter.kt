package br.com.celestial.apicore.resouces.adapter.expense

import br.com.celestial.apicore.domain.entity.Expense
import br.com.celestial.apicore.resouces.document.ExpenseDocument

fun ExpenseDocument.toExpense(): Expense = Expense(
    id = this.id,
    value = this.value,
    reason = this.reason,
    expenseType = this.expenseType,
    costCenterId = this.costCenterId,
    createdAt = this.createdAt
)
