package br.com.celestial.apicore.domain.usecase.expense

import br.com.celestial.apicore.domain.datasource.ExpenseDataSource
import br.com.celestial.apicore.domain.entity.Expense
import br.com.celestial.apicore.domain.usecase.Usecase
import br.com.celestial.apicore.infrastructure.exception.InvalidUsecaseException
import org.springframework.stereotype.Service


@Service
class ExpenseGetUsecase(
    private val dataSource: ExpenseDataSource
) : Usecase<String, Expense> {

    override fun execute(input: String): Expense =
        dataSource.findById(input) ?: throw InvalidUsecaseException("does not exists an expense with id: $input")

}
