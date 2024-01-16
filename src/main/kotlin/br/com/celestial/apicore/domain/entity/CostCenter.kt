package br.com.celestial.apicore.domain.entity

import br.com.celestial.apicore.common.util.sum
import java.math.BigDecimal
import java.math.BigDecimal.ZERO

data class CostCenter (
    val id: String,
    val name: String,
    val expenses: List<Expenses>? = null
){
     val total: BigDecimal
        get() = expenses?.let { e -> e.map { it.value }.sum() } ?: ZERO

}
