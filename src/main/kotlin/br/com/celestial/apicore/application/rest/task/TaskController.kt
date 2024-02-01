package br.com.celestial.apicore.application.rest.task

import br.com.celestial.apicore.application.rest.task.request.TaskCreateRequest
import br.com.celestial.apicore.application.rest.task.request.TaskUpdateStatusRequest
import br.com.celestial.apicore.application.rest.task.response.TaskCreateResponse
import br.com.celestial.apicore.application.rest.task.response.TaskGetAllResponse
import br.com.celestial.apicore.application.rest.task.response.TaskGetResponse
import br.com.celestial.apicore.application.rest.task.response.toResponse
import br.com.celestial.apicore.common.util.ResponseEntityUtil.Companion.created
import br.com.celestial.apicore.domain.usecase.task.TaskCreateUsecase
import br.com.celestial.apicore.domain.usecase.task.TaskDeleteUsecase
import br.com.celestial.apicore.domain.usecase.task.TaskFindAllUsecase
import br.com.celestial.apicore.domain.usecase.task.TaskGetUsecase
import br.com.celestial.apicore.domain.usecase.task.TaskUpdateStatusUsecase
import br.com.celestial.apicore.infrastructure.Sl4jLogger
import br.com.celestial.apicore.infrastructure.info
import jakarta.validation.Valid
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("task", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class TaskController(
    private val create: TaskCreateUsecase,
    private val get: TaskGetUsecase,
    private val delete: TaskDeleteUsecase,
    private val patch: TaskUpdateStatusUsecase,
    private val findAll: TaskFindAllUsecase,
): Sl4jLogger() {
    @PostMapping
    fun create(@Valid @RequestBody request: TaskCreateRequest): ResponseEntity<TaskCreateResponse> = created(
        TaskCreateResponse(create.execute(request.toEntity()).also {
            logger.info { "created task $it" }
        })
    )

    @PatchMapping
    fun patchStatus(@Valid @RequestBody request: TaskUpdateStatusRequest): ResponseEntity<Unit> = ok(
        patch.execute(request.toEntity()).also {
            logger.info {"update status from task $it"}
        }
    )

    @GetMapping("/{id}")
    fun get(@Valid @PathVariable id: String): ResponseEntity<TaskGetResponse> = ok(
        TaskGetResponse(get.execute(id).also {
            logger.info { "returning task $it" }
        })
    )

    @GetMapping
    fun getAll(): ResponseEntity<List<TaskGetAllResponse>> = ok(
        findAll.execute(Unit)?.toResponse().also {
            logger.info { "getting all task: $it" }
        }
    )

    @DeleteMapping("/{id}")
    fun delete(@Valid @PathVariable id: String): ResponseEntity<Unit> = noContent().apply {
        delete.execute(id).also {
            logger.info{ "deleted task with id: $id" }
        }
    }.build()

}

