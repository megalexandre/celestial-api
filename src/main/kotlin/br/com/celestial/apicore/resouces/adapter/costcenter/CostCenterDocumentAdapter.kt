package br.com.celestial.apicore.resouces.adapter.costcenter

import br.com.celestial.apicore.domain.entity.CostCenter
import br.com.celestial.apicore.resouces.adapter.expense.toExpense
import br.com.celestial.apicore.resouces.document.CostCenterDocument

fun CostCenterDocument.toCostCenter() = CostCenter(
    id = this.id,
    name = this.name,
    expenses = this.expenses?.map { it.toExpense() }
)
