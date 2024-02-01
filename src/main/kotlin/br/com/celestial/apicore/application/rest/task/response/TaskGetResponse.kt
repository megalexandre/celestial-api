package br.com.celestial.apicore.application.rest.task.response

import br.com.celestial.apicore.application.rest.components.adapter.ResponseAdapter
import br.com.celestial.apicore.common.enums.TaskStatus
import br.com.celestial.apicore.domain.entity.Task
import java.time.LocalDateTime

data class TaskGetResponse (
    val id: String,
    val title: String,
    val description: String,
    val status: TaskStatus,
    val createdAt: LocalDateTime,
): ResponseAdapter<Task, TaskGetResponse> {
    constructor(task: Task) : this(
        id = task.id,
        title = task.title,
        description = task.description,
        status = task.status,
        createdAt = task.createdAt,
    )
}



