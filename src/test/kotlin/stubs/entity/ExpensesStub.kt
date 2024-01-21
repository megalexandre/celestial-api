package stubs.entity

import br.com.celestial.apicore.domain.entity.Expense
import io.azam.ulidj.ULID.random
import java.math.BigDecimal.TEN
import java.time.LocalDateTime.now

val expenseStub = Expense(
    id = random(),
    value =  TEN,
    reason = "Teste",
    costCenter = costCenterStub,
    createdAt = now(),
)