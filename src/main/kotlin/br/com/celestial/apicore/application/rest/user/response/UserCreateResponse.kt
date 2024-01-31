package br.com.celestial.apicore.application.rest.user.response

import br.com.celestial.apicore.application.rest.components.adapter.ResponseAdapter
import br.com.celestial.apicore.domain.entity.User

data class UserCreateResponse (
    val id: String,

): ResponseAdapter<User, UserCreateResponse> {
    constructor(user: User) : this(
        id = user.id,
    )
}



