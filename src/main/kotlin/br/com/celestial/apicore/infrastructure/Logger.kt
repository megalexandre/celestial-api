package br.com.celestial.apicore.infrastructure

import org.slf4j.Logger
import org.slf4j.LoggerFactory

abstract class Logger {

    protected val logger: Logger = LoggerFactory.getLogger(javaClass)

}
