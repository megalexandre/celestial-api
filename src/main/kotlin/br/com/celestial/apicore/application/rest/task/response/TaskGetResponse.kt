package br.com.celestial.apicore.application.rest.task.response

import br.com.celestial.apicore.application.rest.components.adapter.ResponseAdapter
import br.com.celestial.apicore.common.enums.TaskStatus
import br.com.celestial.apicore.domain.entity.Task

data class TaskGetResponse (
    val title: String,
    val description: String,
    val status: TaskStatus,
): ResponseAdapter<Task, TaskGetResponse> {
    constructor(task: Task) : this(
        title = task.title,
        description = task.description,
        status = task.status,
    )
}



