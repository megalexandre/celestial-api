package br.com.celestial.apicore.resouces.adapter.expense

import br.com.celestial.apicore.domain.entity.Expense
import br.com.celestial.apicore.resouces.adapter.costcenter.toCostCenterDocument
import br.com.celestial.apicore.resouces.document.ExpenseDocument

fun Expense.toExpenseDocument(): ExpenseDocument = ExpenseDocument(
    id = this.id,
    value = this.value,
    reason = this.reason,
    costCenter = this.costCenter.toCostCenterDocument(),
    createdAt = this.createdAt
)
