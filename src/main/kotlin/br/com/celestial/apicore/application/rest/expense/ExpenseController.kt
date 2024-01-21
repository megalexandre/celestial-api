package br.com.celestial.apicore.application.rest.expense

import br.com.celestial.apicore.application.rest.expense.request.ExpenseCreateRequest
import br.com.celestial.apicore.domain.usecase.expense.ExpenseCreateUsecase
import jakarta.validation.Valid
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("expense", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class ExpenseController(
    private val create: ExpenseCreateUsecase,
){
    @PostMapping
    fun create(@Valid @RequestBody request: ExpenseCreateRequest) = create.execute(request.toEntity())

}

