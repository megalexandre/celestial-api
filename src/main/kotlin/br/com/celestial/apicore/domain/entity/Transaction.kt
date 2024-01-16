package br.com.celestial.apicore.domain.entity

import br.com.celestial.apicore.common.enums.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class Transaction (

    val id: String,

    val wallet: Wallet,
    val value: BigDecimal,
    val transactionType: TransactionType,

    val createdAt: LocalDateTime,
)