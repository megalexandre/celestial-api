package br.com.celestial.apicore.application.rest.task.request

import br.com.celestial.apicore.application.rest.components.adapter.RequestAdapter
import br.com.celestial.apicore.common.enums.TaskStatus
import br.com.celestial.apicore.domain.dto.task.TaskUpdateStatus

data class TaskUpdateStatusRequest (
    val id: String,
    val status: TaskStatus,

): RequestAdapter<TaskUpdateStatus> {

    override fun toEntity(): TaskUpdateStatus = TaskUpdateStatus(
        id = id,
        status = status,
    )

}
