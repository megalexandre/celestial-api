package br.com.celestial.apicore.resouces.adapter.user

import br.com.celestial.apicore.domain.entity.User
import br.com.celestial.apicore.resouces.document.UserDocument

fun User.toUserDocument() = UserDocument(
    id = this.id,
    name = this.name,
    documentNumber = documentNumber,
    phoneNumbers = phoneNumbers,
    active = active
)

