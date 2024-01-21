package br.com.celestial.apicore.resouces.event

import br.com.celestial.apicore.resouces.document.interfaces.DocumentItem
import org.springframework.context.ApplicationEvent

class CreatedDocumentEvent(event: String, val payload: DocumentItem): ApplicationEvent(event)
