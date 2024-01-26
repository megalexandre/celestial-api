package br.com.celestial.apicore.domain.dto.expense

import br.com.celestial.apicore.common.enums.ExpenseType
import br.com.celestial.apicore.domain.entity.CostCenter
import br.com.celestial.apicore.domain.entity.Expense
import java.math.BigDecimal
import java.time.LocalDateTime

class CreateExpense (
    val id: String,
    val value: BigDecimal,
    val reason: String,
    val expenseType: ExpenseType,
    val costCenterId: String,
    val createdAt: LocalDateTime,
) {
    fun toExpense(costCenter: CostCenter): Expense = Expense(
        id = id,
        value = value,
        reason = reason,
        expenseType = expenseType,
        costCenterId = costCenterId,
        createdAt = createdAt,
    )
}