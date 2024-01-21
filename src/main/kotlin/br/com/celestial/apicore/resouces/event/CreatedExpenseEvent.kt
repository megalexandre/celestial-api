package br.com.celestial.apicore.resouces.event

import java.math.BigDecimal
import org.springframework.context.ApplicationEvent

class CreatedExpenseEvent(
    val event: String,
    val costCenterId: String,
    val payload: BigDecimal
): ApplicationEvent(event)
