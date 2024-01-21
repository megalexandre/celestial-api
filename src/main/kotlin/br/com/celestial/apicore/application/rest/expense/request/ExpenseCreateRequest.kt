package br.com.celestial.apicore.application.rest.expense.request

import br.com.celestial.apicore.application.rest.components.adapter.RequestAdapter
import br.com.celestial.apicore.domain.dto.expense.CreateExpense
import io.azam.ulidj.ULID.random
import jakarta.validation.constraints.NotEmpty
import java.math.BigDecimal
import java.time.LocalDateTime.now

data class ExpenseCreateRequest (

    @field:NotEmpty(message = "campo motivo não pode ser vazio")
    val reason: String,

    val value: BigDecimal,

    val costCenterId: String

): RequestAdapter<CreateExpense> {

    override fun toEntity(): CreateExpense = CreateExpense(
        id = random(),
        value = value,
        reason = reason,
        costCenterId = costCenterId,
        createdAt = now()
    )

}