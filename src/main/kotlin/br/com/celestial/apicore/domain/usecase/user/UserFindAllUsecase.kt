package br.com.celestial.apicore.domain.usecase.user

import br.com.celestial.apicore.domain.datasource.UserDataSource
import br.com.celestial.apicore.domain.entity.User
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service


@Service
class UserFindAllUsecase(
    private val dataSource: UserDataSource
) : Usecase<Unit, List<User>?> {

    override fun execute(input: Unit): List<User>? = dataSource.findAll()

}
