package br.com.celestial.apicore.domain.usecase.task

import br.com.celestial.apicore.domain.datasource.TaskDataSource
import br.com.celestial.apicore.domain.dto.task.TaskUpdateStatus
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service


@Service
class TaskUpdateStatusUsecase(
    private val dataSource: TaskDataSource,
    private val get: TaskGetUsecase,
) : Usecase<TaskUpdateStatus, Unit> {
    override fun execute(input: TaskUpdateStatus){
        dataSource.save(get.execute(input.id).copy(status = input.status))
    }

}
