package br.com.celestial.apicore.infrastructure

import br.com.celestial.apicore.infrastructure.exception.InvalidUsecaseException
import java.time.LocalDateTime
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class AppAdvice {

	private var logger: Logger = LoggerFactory.getLogger(this::class.java)

	@ExceptionHandler(value = [InvalidUsecaseException::class])
	fun e1 (ex: RuntimeException) = ResponseEntity.badRequest().body(
		mapOf(
			"time" to LocalDateTime.now().toString(),
			"message" to ex.message
		)
	)

}