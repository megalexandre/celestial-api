package br.com.celestial.apicore.resouces.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "CenterCost")
data class CostCenterDocument(

    @Id
    val id: String,

    val name: String,

)