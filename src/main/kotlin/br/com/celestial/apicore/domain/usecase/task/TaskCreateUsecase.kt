package br.com.celestial.apicore.domain.usecase.task

import br.com.celestial.apicore.domain.datasource.TaskDataSource
import br.com.celestial.apicore.domain.entity.Task
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service


@Service
class TaskCreateUsecase(
    private val dataSource: TaskDataSource
) : Usecase<Task, Task> {
    override fun execute(input: Task): Task =
        dataSource.save(input)

}
