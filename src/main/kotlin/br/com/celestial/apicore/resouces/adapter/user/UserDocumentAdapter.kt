package br.com.celestial.apicore.resouces.adapter.user

import br.com.celestial.apicore.domain.entity.User
import br.com.celestial.apicore.resouces.document.UserDocument

fun UserDocument.toUser() = User(
    id = this.id,
    name = this.name,
    documentNumber = documentNumber,
    birthDay =birthDay,
    phoneNumbers = phoneNumbers,
    active = active,
)

