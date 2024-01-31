package br.com.celestial.apicore.domain.usecase.expense

import br.com.celestial.apicore.domain.datasource.ExpenseDataSource
import br.com.celestial.apicore.domain.entity.Expense
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service


@Service
class ExpenseFindAllUsecase(
    private val dataSource: ExpenseDataSource
) : Usecase<Unit, List<Expense>?> {
    override fun execute(input: Unit): List<Expense>? = dataSource.findAll()

}
