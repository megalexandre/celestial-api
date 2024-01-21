package br.com.celestial.apicore.resouces.document

import br.com.celestial.apicore.domain.entity.DocumentNumber
import br.com.celestial.apicore.domain.entity.PhoneNumber
import br.com.celestial.apicore.resouces.document.interfaces.DocumentItem
import java.time.LocalDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class UserDocument(

    @Id
    val id: String,

    val name: String,

    val documentNumber: DocumentNumber,

    var birthDay: LocalDate? = null,

    val phoneNumbers: List<PhoneNumber>? = null,

    val active: Boolean

): DocumentItem
