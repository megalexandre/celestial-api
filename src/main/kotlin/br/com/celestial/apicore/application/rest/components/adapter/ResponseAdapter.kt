package br.com.celestial.apicore.application.rest.components.adapter

fun interface ResponseAdapter<in Entity, out T> {
    fun toResponse(entity: Entity): T

}