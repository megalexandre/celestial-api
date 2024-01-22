package br.com.celestial.apicore.domain.entity

import br.com.celestial.apicore.common.enums.PersonType
import br.com.celestial.apicore.common.enums.PersonType.INDIVIDUAL
import br.com.celestial.apicore.common.enums.PersonType.LEGAL
import br.com.celestial.apicore.common.enums.PersonType.UNKNOWN

data class DocumentNumber(
    val number: String
){
    companion object{
        private const val MAXIMUM_SIZE = 3
        private const val CPF_SIZE = 11
        private const val CNPJ_SIZE = 14

    }

    val type: PersonType = when(number.length){
        CPF_SIZE -> INDIVIDUAL
        CNPJ_SIZE -> LEGAL
        else -> UNKNOWN
    }

    val isValid: Boolean = when(type){
        INDIVIDUAL, LEGAL -> valid(number)
        UNKNOWN -> false
    }

    private fun valid(value: String): Boolean {
        val numbers = value.filter { it.isDigit() }.map { it.toString().toInt() }.toIntArray()

        if ((type == INDIVIDUAL && numbers.size != CPF_SIZE) ||
            (type == LEGAL && numbers.size != CNPJ_SIZE) ||
            numbers.toSet().size == 1
        ) {
            return false
        }

        val dv1 = verifyDigit(numbers.copyOf(if (type == INDIVIDUAL) 9 else 12))
        val dv2 = verifyDigit(numbers.copyOf(if (type == INDIVIDUAL) 10 else 13).plus(dv1))

        return dv1 == numbers[if (type == INDIVIDUAL) 9 else 12] && dv2 == numbers[if (type == INDIVIDUAL) 10 else 13]
    }
    private fun verifyDigit(number: IntArray): Int {
        val start = number.size + 1
        val sum = number.mapIndexed { i, d -> d * (start - i) }.sum()
        val residual = sum % 11
        return if (residual < 2) 0 else 11 - residual
    }

    override fun toString(): String = when(number.length > MAXIMUM_SIZE){
        true ->  number.substring(0, MAXIMUM_SIZE)
        false -> number
    }
}
