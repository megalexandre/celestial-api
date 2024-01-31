package br.com.celestial.apicore.application.rest.task.response

import br.com.celestial.apicore.application.rest.components.adapter.ResponseAdapter
import br.com.celestial.apicore.domain.entity.Task

data class TaskCreateResponse (
    val id: String,

): ResponseAdapter<Task, TaskCreateResponse> {
    constructor(task: Task) : this(
        id = task.id,
    )

}



