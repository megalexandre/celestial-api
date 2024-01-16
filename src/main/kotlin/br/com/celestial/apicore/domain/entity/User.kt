package br.com.celestial.apicore.domain.entity

import br.com.celestial.apicore.domain.entity.interfaces.Entity
import java.time.LocalDate

data class User (

    val id: String,
    val name: String,
    val documentNumber: DocumentNumber,
    var birthDay: LocalDate? = null,
    val phoneNumbers: List<PhoneNumber>? = null,
    val active: Boolean

): Entity