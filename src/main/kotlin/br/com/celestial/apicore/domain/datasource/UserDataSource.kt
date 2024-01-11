package br.com.celestial.apicore.domain.datasource

import br.com.celestial.apicore.domain.entity.DocumentNumber
import br.com.celestial.apicore.domain.entity.User

interface UserDataSource: CustomDataSource<User> {

    fun findByDocument(documentNumber: DocumentNumber): User?

}