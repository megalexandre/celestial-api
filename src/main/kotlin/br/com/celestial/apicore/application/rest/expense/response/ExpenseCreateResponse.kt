package br.com.celestial.apicore.application.rest.expense.response

import br.com.celestial.apicore.application.rest.components.adapter.ResponseAdapter
import br.com.celestial.apicore.domain.entity.Expense

data class ExpenseCreateResponse (
    val id: String,
): ResponseAdapter<Expense, ExpenseCreateResponse> {
    constructor(expense: Expense) : this(
        id = expense.id,
    )
}

