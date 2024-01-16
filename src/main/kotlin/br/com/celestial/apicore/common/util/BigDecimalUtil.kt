package br.com.celestial.apicore.common.util

import java.math.BigDecimal
import java.math.BigDecimal.ZERO

fun List<BigDecimal>?.sum(): BigDecimal = this?.fold(ZERO) { acc, expense -> acc + expense } ?: ZERO
