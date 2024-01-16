package stubs.entity

import br.com.celestial.apicore.domain.entity.Expenses
import io.azam.ulidj.ULID.random
import java.math.BigDecimal.TEN
import java.time.LocalDateTime.now

val expensesStub = Expenses(
    id = random(),
    value =  TEN,
    reason = "Teste",
    createdAt = now(),
)