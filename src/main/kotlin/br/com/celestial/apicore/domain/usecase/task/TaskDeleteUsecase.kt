package br.com.celestial.apicore.domain.usecase.task

import br.com.celestial.apicore.domain.datasource.TaskDataSource
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service


@Service
class TaskDeleteUsecase(
    private val dataSource: TaskDataSource,
) : Usecase<String, Unit> {
    override fun execute(input: String){
        dataSource.delete(input)
    }

}
