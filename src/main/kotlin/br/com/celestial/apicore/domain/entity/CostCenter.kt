package br.com.celestial.apicore.domain.entity

import br.com.celestial.apicore.common.util.sum
import java.math.BigDecimal
import java.math.BigDecimal.ZERO
import java.time.LocalDateTime.now


data class CostCenter (
    val id: String,
    val name: String,
    val expenses: List<Expense>? = null
){
    val total: BigDecimal
       get() = expenses
           ?.let { e -> e.map { it.value }.sum() }
           ?: ZERO

    val totalCurrentMonth: BigDecimal
        get() = expenses
            ?.filter { it.createdAt.month == now().month }
            ?.let { e -> e.map { it.value }.sum() }
            ?: ZERO

}
