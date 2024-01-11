package br.com.celestial.apicore.domain.entity

data class DocumentNumber(
    val number: String
){
    companion object{
        private const val MAXIMUM_SIZE = 3
    }

    override fun toString(): String = when(number.length > MAXIMUM_SIZE){
        true ->  number.substring(0, MAXIMUM_SIZE)
        false -> number
    }

}
