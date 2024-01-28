package br.com.celestial.apicore.domain.usecase.expense

import br.com.celestial.apicore.domain.datasource.ExpenseDataSource
import br.com.celestial.apicore.domain.usecase.Usecase
import io.azam.ulidj.ULID.random
import org.springframework.stereotype.Service


@Service
class ExpenseDeleteUsecase(
    private val dataSource: ExpenseDataSource,
    private val get: ExpenseGetUsecase,
) : Usecase<String, Unit> {
    override fun execute(input: String){
        dataSource.save(
            get.execute(input).let {
                it.copy(
                    id = random(),
                    parentId = it.id,
                    value = it.value.negate()
                )
            }
        )
    }

}
