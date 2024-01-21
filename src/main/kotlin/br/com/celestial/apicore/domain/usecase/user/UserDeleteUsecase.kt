package br.com.celestial.apicore.domain.usecase.user

import br.com.celestial.apicore.domain.datasource.UserDataSource
import br.com.celestial.apicore.domain.usecase.Usecase
import org.springframework.stereotype.Service


@Service
class UserDeleteUsecase(
    private val get: UserGetUsecase,
    private val dataSource: UserDataSource
) : Usecase<String, Unit> {

    override fun execute(input: String): Unit = dataSource.delete(get.execute(input).id)

}
