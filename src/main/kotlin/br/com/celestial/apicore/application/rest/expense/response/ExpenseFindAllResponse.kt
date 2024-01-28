package br.com.celestial.apicore.application.rest.expense.response

import br.com.celestial.apicore.application.rest.components.adapter.ResponseAdapter
import br.com.celestial.apicore.common.enums.ExpenseType
import br.com.celestial.apicore.domain.entity.Expense
import java.math.BigDecimal

data class ExpenseFindAllResponse (
    val id: String,
    val parentId: String? = null,
    val value: BigDecimal,
    val reason: String,
    val expenseType: ExpenseType,

): ResponseAdapter<Expense, ExpenseFindAllResponse> {
    constructor(expense: Expense) : this(
        id = expense.id,
        parentId = expense.parentId,
        value = expense.value,
        reason = expense.reason,
        expenseType = expense.expenseType,
    )

    override fun toResponse(entity: Expense): ExpenseFindAllResponse =  ExpenseFindAllResponse(entity)
}

fun List<Expense>.toResponse(): List<ExpenseFindAllResponse> = this.map { ExpenseFindAllResponse(it) }
