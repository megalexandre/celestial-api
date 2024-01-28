package br.com.celestial.apicore.domain.entity

import br.com.celestial.apicore.common.enums.ExpenseType
import java.math.BigDecimal
import java.time.LocalDateTime

data class Expense (
    val id: String,
    val parentId: String? = null,
    val value: BigDecimal,
    val reason: String,
    val expenseType: ExpenseType,
    val costCenterId: String,
    val createdAt: LocalDateTime,
)