package br.com.celestial.apicore.domain.entity

data class CNPJ(
    val number: String
){
    companion object {
        private const val MAXIMUM_SIZE = 2
    }

    val valid: Boolean
        get() = this.valid()
    private fun valid(): Boolean = isValidCNPJ(number)

    private fun isValidCNPJ(cnpj: String): Boolean {
        if (cnpj.length != 14) return false
        val numbers = cnpj.toCharArray().map { it.digitToInt() }
        if (numbers.all { i ->  i == numbers[0] }) {
            return false
        }

        val firstDigit = calculateFirstDigitVerifier(numbers)
        if (firstDigit != numbers[12]) return false

        val secondDigit = calculateSecondDigitVerifier(numbers)

        return secondDigit == numbers[13]
    }

    private fun calculateFirstDigitVerifier(numbers: List<Int>): Int {
        val multipliers = listOf(5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
        val sum = numbers.take(12).foldIndexed(0) { index, acc, i -> acc + i * multipliers[index] }
        val remainder = sum % 11
        return if (remainder < 2) 0 else 11 - remainder
    }

    private fun calculateSecondDigitVerifier(numbers: List<Int>): Int {
        val multipliers = listOf(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
        val sum = numbers.take(13).foldIndexed(0) { index, acc, i -> acc + i * multipliers[index] }
        val remainder = sum % 11
        return if (remainder < 2) 0 else 11 - remainder
    }

    override fun toString(): String = when (number.length > MAXIMUM_SIZE) {
        true ->  number.substring(0, MAXIMUM_SIZE)
        false -> number
    }
}