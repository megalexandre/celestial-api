package br.com.celestial.apicore.application.rest.expense

import br.com.celestial.apicore.application.rest.expense.request.ExpenseCreateRequest
import br.com.celestial.apicore.application.rest.expense.response.ExpenseCreateResponse
import br.com.celestial.apicore.application.rest.expense.response.ExpenseFindAllResponse
import br.com.celestial.apicore.application.rest.expense.response.ExpenseGetResponse
import br.com.celestial.apicore.application.rest.expense.response.toResponse
import br.com.celestial.apicore.domain.usecase.expense.ExpenseCreateUsecase
import br.com.celestial.apicore.domain.usecase.expense.ExpenseDeleteUsecase
import br.com.celestial.apicore.domain.usecase.expense.ExpenseFindAllUsecase
import br.com.celestial.apicore.domain.usecase.expense.ExpenseGetUsecase
import br.com.celestial.apicore.infrastructure.Sl4jLogger
import br.com.celestial.apicore.infrastructure.info
import jakarta.validation.Valid
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.noContent
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("expense", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class ExpenseController(
    private val create: ExpenseCreateUsecase,
    private val get: ExpenseGetUsecase,
    private val findAll: ExpenseFindAllUsecase,
    private val delete: ExpenseDeleteUsecase,
): Sl4jLogger() {

    @PostMapping
    fun create(@Valid @RequestBody request: ExpenseCreateRequest): ResponseEntity<ExpenseCreateResponse> = run {
        logger.info { "creating expense with data: $request" }
        ResponseEntity(ExpenseCreateResponse(create.execute(request.toEntity())), CREATED).also {
            logger.info { "created expense with data: $request" }
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@Valid @PathVariable id: String): ResponseEntity.HeadersBuilder<*> = run {
        logger.info{"deleting expense with id: $id"}
        delete.execute(id)
        logger.info{"deleted expense with id: $id"}
        noContent()
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<ExpenseFindAllResponse>> = run {
        logger.info{"getting all expenses"}
        ok(findAll.execute(Unit)?.toResponse())
            .also {
                logger.info{"returning all expenses"}
            }
    }

    @GetMapping("/{id}")
    fun get(@Valid @PathVariable id: String): ResponseEntity<ExpenseGetResponse> = run {
        logger.info{"getting expense by id $id"}
        ok(ExpenseGetResponse(get.execute(id))
            .also {
                logger.info{"get expense $it"}
            })
    }

}

