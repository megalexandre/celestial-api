package br.com.celestial.apicore.domain.usecase

import br.com.celestial.apicore.domain.datasource.UserDataSource
import br.com.celestial.apicore.domain.entity.User
import br.com.celestial.apicore.domain.exception.InvalidUsecaseException

class CreateUserUseCase(
    private val dataSource: UserDataSource
) : Usecase<User, User> {

    override fun execute(input: User): User =
        valid(input).let {
            dataSource.save(input)
        }

    private fun valid(input: User){
        dataSource.findByDocument(documentNumber = input.documentNumber)?.let {
            throw InvalidUsecaseException("duplicated document number: ${input.documentNumber}")
        }
    }
}
