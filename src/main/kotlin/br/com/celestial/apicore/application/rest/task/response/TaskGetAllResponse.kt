package br.com.celestial.apicore.application.rest.task.response

import br.com.celestial.apicore.application.rest.components.adapter.ResponseAdapter
import br.com.celestial.apicore.common.enums.TaskStatus
import br.com.celestial.apicore.domain.entity.Task

data class TaskGetAllResponse (
    val id: String,
    val title: String,
    val description: String,
    val status: TaskStatus,
): ResponseAdapter<Task, TaskGetAllResponse> {
    constructor(task: Task) : this(
        id = task.id,
        title = task.title,
        description = task.description,
        status = task.status,
    )
}

fun List<Task>.toResponse(): List<TaskGetAllResponse> = this.map { TaskGetAllResponse(it) }

