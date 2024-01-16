package br.com.celestial.apicore.domain.usecase

import br.com.celestial.apicore.domain.datasource.UserDataSource
import br.com.celestial.apicore.domain.exception.InvalidUsecaseException
import br.com.celestial.apicore.domain.usecase.user.CreateUser
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import stubs.entity.userStub

class CreateUserTest {

    private val dataSource = mockk<UserDataSource>()
    private val useCase = CreateUser(dataSource = dataSource)

    @Test
    fun `GIVEN a new user is created WHEN document number already exists THEN do not save him`() {
        val user = userStub

        every {
            dataSource.findByDocument(user.documentNumber)
        } returns user

        assertThrows<InvalidUsecaseException> {
            useCase.execute(user)
        }

    }

    @Test
    fun `GIVEN a new user is created WHEN document number not exists THEN save him`() {
        val user = userStub

        every {
            dataSource.findByDocument(user.documentNumber)
        } returns null

        every {
            dataSource.save(any())
        } returns user

        useCase.execute(user)
    }

}
