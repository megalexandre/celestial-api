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
){
    @PostMapping
    fun create(@Valid @RequestBody request: ExpenseCreateRequest): ResponseEntity<ExpenseCreateResponse> =
        ResponseEntity(ExpenseCreateResponse(create.execute(request.toEntity())), CREATED)

    @DeleteMapping("/{id}")
    fun delete(@Valid @PathVariable id: String): ResponseEntity.HeadersBuilder<*> = run {
        delete.execute(id)
        noContent()
    }

    @GetMapping
    fun getAll(): ResponseEntity<List<ExpenseFindAllResponse>> =
        ok(findAll.execute(Unit)?.toResponse())

    @GetMapping("/{id}")
    fun get(@Valid @PathVariable id: String): ResponseEntity<ExpenseGetResponse> =
        ok(ExpenseGetResponse(get.execute(id)))
}

