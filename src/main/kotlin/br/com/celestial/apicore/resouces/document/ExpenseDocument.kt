package br.com.celestial.apicore.resouces.document

import br.com.celestial.apicore.common.enums.ExpenseType
import br.com.celestial.apicore.resouces.document.interfaces.DocumentItem
import java.math.BigDecimal
import java.time.LocalDateTime
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "expense")
data class ExpenseDocument(

    @Id
    val id: String,

    val parentId: String? = null,

    val costCenterId: String,

    val value: BigDecimal,

    val expenseType: ExpenseType,

    val reason: String,

    val createdAt: LocalDateTime,

    ): DocumentItem