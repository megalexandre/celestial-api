package br.com.celestial.apicore.resouces.datasourceImp

import br.com.celestial.apicore.domain.datasource.ExpenseDataSource
import br.com.celestial.apicore.domain.entity.Expense
import br.com.celestial.apicore.resouces.adapter.expense.toExpense
import br.com.celestial.apicore.resouces.adapter.expense.toExpenseDocument
import br.com.celestial.apicore.resouces.repository.centercost.ExpenseRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.stereotype.Repository

@Repository
class ExpenseDataSourceImpl(
    private val repository: ExpenseRepository,
    private val mongoTemplate: MongoTemplate,
    private val publisher: ApplicationEventPublisher,
): ExpenseDataSource {

    override fun save(t: Expense): Expense = repository.save(t.toExpenseDocument()).toExpense()

    override fun delete(id: String) {
        repository.deleteById(id)
    }

    override fun findAll(): List<Expense> = repository.findAll().map { it.toExpense() }

    override fun findById(id: String): Expense? = repository.findById(id).map { it.toExpense() }.getOrNull()

}
