package br.com.celestial.apicore.domain.entity

import java.math.BigDecimal
import java.math.BigDecimal.ZERO

data class CostCenter (
    val id: String,
    val name: String,
    val expenses: List<Expenses>? = null
){
     val total: BigDecimal
        get() = expenses?.fold(ZERO) { acc, expense -> acc + expense.value } ?: ZERO
}
