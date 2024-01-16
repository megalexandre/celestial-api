package br.com.celestial.apicore.application.rest.components.adapter

fun interface RequestAdapter<out T> {

    fun toEntity(): T

}