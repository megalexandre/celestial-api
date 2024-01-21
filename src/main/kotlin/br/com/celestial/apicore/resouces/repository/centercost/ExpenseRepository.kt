package br.com.celestial.apicore.resouces.repository.centercost

import br.com.celestial.apicore.resouces.document.ExpenseDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface ExpenseRepository : MongoRepository<ExpenseDocument, String>