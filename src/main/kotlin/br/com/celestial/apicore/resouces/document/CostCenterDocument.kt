package br.com.celestial.apicore.resouces.document

import br.com.celestial.apicore.resouces.document.interfaces.DocumentItem
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "cost_center")
data class CostCenterDocument(

    @Id
    val id: String,

    val name: String,

    val expenses: List<ExpenseDocument>? = null

): DocumentItem