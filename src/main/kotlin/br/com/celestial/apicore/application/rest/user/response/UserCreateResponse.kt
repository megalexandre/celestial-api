package br.com.celestial.apicore.application.rest.user.response

import br.com.celestial.apicore.application.rest.components.adapter.ResponseAdapter
import br.com.celestial.apicore.domain.entity.PhoneNumber
import br.com.celestial.apicore.domain.entity.User
import java.time.LocalDate

data class UserCreateResponse (
    val id: String,
    val name: String,
    val documentNumber: String,
    var birthDay: LocalDate? = null,
    val phoneNumbers: List<PhoneNumber>?,
    val active: Boolean

): ResponseAdapter<User, UserCreateResponse> {
    constructor(user: User) : this(
        id = user.id,
        name = user.name,
        documentNumber = user.documentNumber.number,
        birthDay = user.birthDay,
        phoneNumbers = user.phoneNumbers ,
        active = user.active,
    )
    override fun toResponse(entity: User): UserCreateResponse =  UserCreateResponse(entity)
}



