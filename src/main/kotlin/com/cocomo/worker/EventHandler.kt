package com.cocomo.worker

import com.cocomo.library.event.Event
import org.springframework.context.event.EventListener

/**
 * @author kyle.kim@daangn.com
 */
class EventHandler {

    @EventListener
    fun handle(event: Event) {
        println(event)
    }
}