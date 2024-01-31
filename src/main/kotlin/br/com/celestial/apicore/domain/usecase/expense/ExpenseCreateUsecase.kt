package br.com.celestial.apicore.domain.usecase.expense

import br.com.celestial.apicore.domain.datasource.ExpenseDataSource
import br.com.celestial.apicore.domain.dto.expense.CreateExpense
import br.com.celestial.apicore.domain.entity.Expense
import br.com.celestial.apicore.domain.usecase.Usecase
import br.com.celestial.apicore.domain.usecase.costcenter.CostCenterGetUsecase
import br.com.celestial.apicore.infrastructure.Logger
import br.com.celestial.apicore.infrastructure.exception.InvalidUsecaseException
import org.springframework.stereotype.Service

@Service
class ExpenseCreateUsecase(
    private val dataSource: ExpenseDataSource,
    private val costCenterGet: CostCenterGetUsecase,
): Usecase<CreateExpense, Expense>, Logger() {
    override fun execute(input: CreateExpense): Expense {

        costCenterGet.execute(input.costCenterId)
            ?: throw InvalidUsecaseException("cost center: ${input.costCenterId} does não exists").also {
                logger.info(
                    "a attempts to save an expense $input was failed, " +
                    "because cost cent does not exists ${input.costCenterId}"
                )
            }

        return dataSource.save(input.toExpense())
    }

}
