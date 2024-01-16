package br.com.celestial.apicore.domain.datasource

interface CustomDataSource<T> {
    fun save(t: T): T
    fun delete(id: String)
    fun findAll(): List<T>
    fun findById(id: String): T?
}