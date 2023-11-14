package com.cocomo.worker

import com.cocomo.library.event.Event
import org.springframework.context.event.EventListener

class EventHandler {

    @EventListener
    fun handle(event: Event) {
        println("Executed. key: ${event.idempotentKey}")
    }
}