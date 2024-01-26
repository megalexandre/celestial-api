package br.com.celestial.apicore.application.rest.expense

import br.com.celestial.apicore.application.rest.expense.request.ExpenseCreateRequest
import br.com.celestial.apicore.application.rest.expense.response.ExpenseGetResponse
import br.com.celestial.apicore.domain.usecase.expense.ExpenseCreateUsecase
import br.com.celestial.apicore.domain.usecase.expense.ExpenseFindAllUsecase
import br.com.celestial.apicore.domain.usecase.expense.ExpenseGetUsecase
import jakarta.validation.Valid
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
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
){
    @PostMapping
    fun create(@Valid @RequestBody request: ExpenseCreateRequest) = create.execute(request.toEntity())

    @GetMapping
    fun getAll(): ResponseEntity<List<ExpenseGetResponse>> =
        ok(findAll.execute(Unit)?.let { c -> c.map { ExpenseGetResponse(it) } })
    @GetMapping("/{id}")
    fun get(@Valid @PathVariable id: String) :ResponseEntity<ExpenseGetResponse> =
        ok(get.execute(id)?.let { ExpenseGetResponse(it) })
}

