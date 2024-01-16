package br.com.celestial.apicore.domain.entity

import java.math.BigDecimal
import java.time.LocalDateTime

data class Expenses (
    val id: String,
    val value: BigDecimal,
    val reason: String,
    val createdAt: LocalDateTime,
)