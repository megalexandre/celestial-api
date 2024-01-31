package br.com.celestial.apicore.domain.usecase.task

import br.com.celestial.apicore.domain.datasource.TaskDataSource
import br.com.celestial.apicore.domain.entity.Task
import br.com.celestial.apicore.domain.usecase.Usecase
import br.com.celestial.apicore.infrastructure.exception.InvalidUsecaseException
import org.springframework.stereotype.Service


@Service
class TaskGetUsecase(
    private val dataSource: TaskDataSource
) : Usecase<String, Task> {

    override fun execute(input: String): Task =
        dataSource.findById(input) ?: throw InvalidUsecaseException("does not exists a task with id: $input")

}
