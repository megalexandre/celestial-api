package br.com.celestial.apicore.domain.entity

import br.com.celestial.apicore.common.enums.PersonType
import br.com.celestial.apicore.domain.entity.interfaces.Entity
import java.time.LocalDate

class User (
    val id: String,
    val name: String,
    val documentNumber: DocumentNumber,
    var birthDay: LocalDate? = null,
    val membershipNumber: String,
    val personType: PersonType,
    val phoneNumbers: List<PhoneNumber>?,
    val active: Boolean
): Entity