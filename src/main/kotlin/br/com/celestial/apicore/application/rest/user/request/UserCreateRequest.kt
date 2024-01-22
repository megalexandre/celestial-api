package br.com.celestial.apicore.application.rest.user.request

import br.com.celestial.apicore.application.rest.components.adapter.RequestAdapter
import br.com.celestial.apicore.application.rest.validator.documentNumber.DocumentNumberValidator
import br.com.celestial.apicore.domain.entity.DocumentNumber
import br.com.celestial.apicore.domain.entity.PhoneNumber
import br.com.celestial.apicore.domain.entity.User
import io.azam.ulidj.ULID.random
import java.time.LocalDate

data class UserCreateRequest (
    val name: String,
    @DocumentNumberValidator
    val documentNumber: String,
    var birthDay: LocalDate? = null,
    val phoneNumbers: List<PhoneNumber>?,

): RequestAdapter<User> {

    override fun toEntity(): User = User(
        id = random(),
        name = name,
        documentNumber = DocumentNumber(documentNumber),
        birthDay = birthDay,
        phoneNumbers = phoneNumbers,
        active = true,
    )

}