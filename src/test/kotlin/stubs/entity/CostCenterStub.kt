package stubs.entity

import br.com.celestial.apicore.domain.entity.CostCenter
import io.azam.ulidj.ULID.random

val costCenterWithoutExpensesStub = CostCenter(
    id = random(),
    name = "teste",
    expenses = null,
)

val costCenterStub = CostCenter(
    id = random(),
    name = "teste",
    expenses = listOf(expensesStub, expensesStub),
)