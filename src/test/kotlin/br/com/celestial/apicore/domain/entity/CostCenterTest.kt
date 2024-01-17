package br.com.celestial.apicore.domain.entity

import br.com.celestial.apicore.common.util.toMonetary
import java.math.BigDecimal
import java.math.BigDecimal.TEN
import java.math.BigDecimal.ZERO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import stubs.entity.costCenterWithoutExpensesStub
import stubs.entity.expensesStub

class CostCenterTest {

    @Test
    fun `GIVEN a cost center has no one expends WHEN call total THEN should be zero`() {
        assertEquals(ZERO.toMonetary(), costCenterWithoutExpensesStub.total)
    }

    @Test
    fun `GIVEN a cost center has expends WHEN call total THEN sum values`() {
        val costCenterWithTwoExpenses = costCenterWithoutExpensesStub.copy(
            expenses = listOf(
                expensesStub.copy(value = TEN),
                expensesStub.copy(value = TEN)
            )
        )

        assertEquals(BigDecimal(20).toMonetary(), costCenterWithTwoExpenses.total)
    }

    @Test
    fun `GIVEN a cost center has expends with cents WHEN call total THEN sum values`() {
        val expected = BigDecimal("12.58").toMonetary()

        val costCenterWithExpensesAndCents = costCenterWithoutExpensesStub.copy(
            expenses = listOf(
                expensesStub.copy(value = BigDecimal(1.22)),
                expensesStub.copy(value = BigDecimal(7.99)),
                expensesStub.copy(value = BigDecimal(3.37))
            )
        )

        assertEquals(expected, costCenterWithExpensesAndCents.total)
    }
}