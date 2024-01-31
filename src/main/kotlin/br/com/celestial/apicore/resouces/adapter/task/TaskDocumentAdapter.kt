package br.com.celestial.apicore.resouces.adapter.task

import br.com.celestial.apicore.domain.entity.Task
import br.com.celestial.apicore.resouces.document.TaskDocument

fun TaskDocument.toTask() = Task(
    id = this.id,
    title = this.title,
    description = this.description,
    status = this.status,
    createdAt = this.createdAt,
)

