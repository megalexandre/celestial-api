package br.com.celestial.apicore.resouces.adapter.expense

import br.com.celestial.apicore.domain.entity.Expense
import br.com.celestial.apicore.resouces.adapter.costcenter.toCostCenter
import br.com.celestial.apicore.resouces.document.ExpenseDocument

fun ExpenseDocument.toExpense(): Expense = Expense(
    id = this.id,
    value = this.value,
    reason = this.reason,
    costCenter = this.costCenter.toCostCenter(),
    createdAt = this.createdAt
)
