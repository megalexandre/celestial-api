package br.com.celestial.apicore.application.rest.expense.response

import br.com.celestial.apicore.application.rest.components.adapter.ResponseAdapter
import br.com.celestial.apicore.common.enums.ExpenseType
import br.com.celestial.apicore.domain.entity.Expense
import java.math.BigDecimal
import java.time.LocalDateTime

data class ExpenseFindResponse (
    val id: String,
    val value: BigDecimal,
    val reason: String,
    val expenseType: ExpenseType,
    val costCenterId: String,
    val createdAt: LocalDateTime,

): ResponseAdapter<Expense, ExpenseFindResponse> {
    constructor(expense: Expense) : this(
        id = expense.id,
        value = expense.value,
        reason = expense.reason,
        expenseType = expense.expenseType,
        costCenterId = expense.costCenterId,
        createdAt = expense.createdAt,
    )

    override fun toResponse(entity: Expense): ExpenseFindResponse =  ExpenseFindResponse(entity)
}

fun List<Expense>.toResponse(): List<ExpenseFindResponse> = this.map { ExpenseFindResponse(it) }
