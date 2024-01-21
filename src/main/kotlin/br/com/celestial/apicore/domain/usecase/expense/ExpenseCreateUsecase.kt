package br.com.celestial.apicore.domain.usecase.expense

import br.com.celestial.apicore.domain.datasource.ExpenseDataSource
import br.com.celestial.apicore.domain.dto.expense.CreateExpense
import br.com.celestial.apicore.domain.entity.Expense
import br.com.celestial.apicore.domain.usecase.Usecase
import br.com.celestial.apicore.domain.usecase.costcenter.CostCenterGetUsecase
import br.com.celestial.apicore.infrastructure.exception.InvalidUsecaseException
import org.springframework.stereotype.Service

@Service
class ExpenseCreateUsecase(
    private val dataSource: ExpenseDataSource,
    private val costCenterGet: CostCenterGetUsecase,
): Usecase<CreateExpense, Expense> {
    override fun execute(input: CreateExpense): Expense {

        val costCenter = costCenterGet.execute(input.costCenterId)
            ?: throw InvalidUsecaseException("cost center: ${input.costCenterId} does não exists")

        return dataSource.save(input.toExpense(costCenter))
    }

}
