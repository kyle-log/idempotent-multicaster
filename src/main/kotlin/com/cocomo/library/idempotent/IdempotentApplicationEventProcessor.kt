package com.cocomo.library.idempotent

import com.cocomo.library.event.ApplicationEventProcessor
import org.springframework.context.ApplicationEvent
import org.springframework.context.PayloadApplicationEvent
import org.springframework.context.event.GenericApplicationListener

class IdempotentApplicationEventProcessor(
    private val delegate: ApplicationEventProcessor,
    private val idempotentExecutor: IdempotentExecutor,
) : ApplicationEventProcessor {
    override fun process(listener: GenericApplicationListener, event: ApplicationEvent) {
        runCatching {
            val payload = (event as PayloadApplicationEvent<*>).payload as IdempotentEvent
            idempotentExecutor.execute(payload.idempotentKey) {
                delegate.process(listener, event)
            }
        }
    }
}