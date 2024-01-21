package br.com.celestial.apicore.domain.usecase.user

import br.com.celestial.apicore.domain.datasource.UserDataSource
import br.com.celestial.apicore.domain.entity.User
import br.com.celestial.apicore.domain.usecase.Usecase
import br.com.celestial.apicore.infrastructure.exception.InvalidUsecaseException
import org.springframework.stereotype.Service


@Service
class UserDeleteUsecase(
    private val dataSource: UserDataSource
) : Usecase<String, User> {

    override fun execute(input: String): User =
        dataSource.findById(input) ?: throw InvalidUsecaseException("does not exists an user with id: $input")

}
