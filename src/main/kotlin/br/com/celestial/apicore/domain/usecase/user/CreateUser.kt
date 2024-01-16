package br.com.celestial.apicore.domain.usecase.user

import br.com.celestial.apicore.domain.datasource.UserDataSource
import br.com.celestial.apicore.domain.entity.User
import br.com.celestial.apicore.domain.exception.InvalidUsecaseException
import br.com.celestial.apicore.domain.usecase.interfaces.Usecase
import org.springframework.stereotype.Service


@Service
class CreateUser(
    private val dataSource: UserDataSource
) : Usecase<User, User> {

    override fun execute(input: User): User =
        valid(input).let {
            dataSource.save(input)
        }

    private fun valid(user: User){ with(user){
        dataSource.findByDocument(documentNumber = documentNumber)?.let {
            throw InvalidUsecaseException("duplicated document number: $documentNumber")
        }}
    }
}
