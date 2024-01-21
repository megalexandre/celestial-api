package br.com.celestial.apicore.resouces.document

import br.com.celestial.apicore.resouces.document.interfaces.DocumentItem
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class UserDocument(

    @Id
    val id: String,

    val name: String,

): DocumentItem