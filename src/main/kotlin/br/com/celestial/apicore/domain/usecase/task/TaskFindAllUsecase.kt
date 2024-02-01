package br.com.celestial.apicore.domain.usecase.task

import br.com.celestial.apicore.domain.datasource.TaskDataSource
import br.com.celestial.apicore.domain.entity.Task
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service


@Service
class TaskFindAllUsecase(
    private val dataSource: TaskDataSource
) : Usecase<Unit, List<Task>?> {
    override fun execute(input: Unit): List<Task>? = dataSource.findAll()

}
