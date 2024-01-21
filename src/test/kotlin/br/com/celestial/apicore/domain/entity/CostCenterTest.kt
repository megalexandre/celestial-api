package br.com.celestial.apicore.domain.entity

import br.com.celestial.apicore.common.util.toMonetary
import java.math.BigDecimal
import java.math.BigDecimal.TEN
import java.math.BigDecimal.ZERO
import java.time.LocalDateTime
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import stubs.entity.costCenterWithoutExpensesStub
import stubs.entity.expenseStub

class CostCenterTest {

    @Test
    fun `GIVEN a cost center has no one expends WHEN call total THEN should be zero`() {
        assertEquals(ZERO.toMonetary(), costCenterWithoutExpensesStub.total)
    }

    @Test
    fun `GIVEN a cost center has expends WHEN call total THEN sum values`() {
        val costCenterWithTwoExpenses = costCenterWithoutExpensesStub.copy(
            expenses = listOf(
                expenseStub.copy(value = TEN),
                expenseStub.copy(value = TEN)
            )
        )

        assertEquals(BigDecimal(20).toMonetary(), costCenterWithTwoExpenses.total)
    }

    @Test
    fun `GIVEN a cost center has expends with cents WHEN call total THEN sum values`() {
        val expected = BigDecimal("12.58").toMonetary()

        val costCenterWithExpensesAndCents = costCenterWithoutExpensesStub.copy(
            expenses = listOf(
                expenseStub.copy(value = BigDecimal(1.22)),
                expenseStub.copy(value = BigDecimal(7.99)),
                expenseStub.copy(value = BigDecimal(3.37))
            )
        )

        assertEquals(expected, costCenterWithExpensesAndCents.total)
    }


    @Test
    fun `GIVEN a cost center has no expends in current month WHEN call total current value THEN response zero`() {
        val expected = ZERO.toMonetary()

        val costCenterWithExpensesDoesOnLastMonths = costCenterWithoutExpensesStub.copy(
            expenses = listOf(
                expenseStub.copy(value = BigDecimal(1.22), createdAt = LocalDateTime.now().minusMonths(1)),
                expenseStub.copy(value = BigDecimal(7.99), createdAt = LocalDateTime.now().minusMonths(3)),
                expenseStub.copy(value = BigDecimal(3.37), createdAt = LocalDateTime.now().minusMonths(2))
            )
        )

        assertEquals(expected, costCenterWithExpensesDoesOnLastMonths.totalCurrentMonth)
    }

    @Test
    fun `GIVEN a cost center has expends in current month WHEN call total current value THEN response zero`() {
        val expected = BigDecimal(1.22).toMonetary()

        val costCenterWithExpensesDoesOnLastMonths = costCenterWithoutExpensesStub.copy(
            expenses = listOf(
                expenseStub.copy(value = BigDecimal(1.22), createdAt = LocalDateTime.now()),
                expenseStub.copy(value = BigDecimal(7.99), createdAt = LocalDateTime.now().minusMonths(3)),
                expenseStub.copy(value = BigDecimal(3.37), createdAt = LocalDateTime.now().minusMonths(2))
            )
        )

        assertEquals(expected, costCenterWithExpensesDoesOnLastMonths.totalCurrentMonth)
    }

}