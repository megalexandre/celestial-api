package br.com.celestial.apicore.resouces.repository.user

import br.com.celestial.apicore.domain.entity.User
import br.com.celestial.apicore.resouces.document.UserDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<UserDocument, String>{
    fun findByDocumentNumber(documentNumber: String): User?
}