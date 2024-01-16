package br.com.celestial.apicore.domain.usecase.user

import br.com.celestial.apicore.domain.datasource.UserDataSource
import br.com.celestial.apicore.domain.entity.User
import br.com.celestial.apicore.domain.exception.InvalidUsecaseException
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service


@Service
class GetUserUseCase(
    private val dataSource: UserDataSource
) : Usecase<String, User> {

    override fun execute(input: String): User =
        dataSource.findById(input) ?: throw InvalidUsecaseException("does not exists an user with id: $input")

}
