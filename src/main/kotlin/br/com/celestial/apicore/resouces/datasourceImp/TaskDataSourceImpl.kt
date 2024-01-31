package br.com.celestial.apicore.resouces.datasourceImp

import br.com.celestial.apicore.domain.datasource.TaskDataSource
import br.com.celestial.apicore.domain.entity.Task
import br.com.celestial.apicore.resouces.adapter.task.toTask
import br.com.celestial.apicore.resouces.adapter.task.toTaskDocument
import br.com.celestial.apicore.resouces.repository.user.TaskRepository
import kotlin.jvm.optionals.getOrNull
import org.springframework.stereotype.Service

@Service
class TaskDataSourceImpl(
    private val repository: TaskRepository,
): TaskDataSource {
    override fun save(t: Task): Task =
        repository.save(t.toTaskDocument()).toTask()

    override fun delete(id: String) {
        repository.deleteById(id)
    }

    override fun findAll(): List<Task>  =
        repository.findAll().map { it.toTask() }

    override fun findById(id: String): Task? =
        repository.findById(id).map { it.toTask() }.getOrNull()

}