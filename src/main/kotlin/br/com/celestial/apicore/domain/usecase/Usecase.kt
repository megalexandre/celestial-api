package br.com.celestial.apicore.domain.usecase

fun interface Usecase<in Input, out Output> {
    fun execute(input: Input): Output
}