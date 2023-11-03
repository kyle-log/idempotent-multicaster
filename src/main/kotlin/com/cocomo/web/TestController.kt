package com.cocomo.web

import com.cocomo.library.event.Event
import com.cocomo.library.event.EventPublisher
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    val eventPublisher: EventPublisher
) {

    @GetMapping
    fun test() {
        val event = Event("Hello")
        eventPublisher.publishEvent(event)
        eventPublisher.publishEvent(event)
        eventPublisher.publishEvent(event)
    }
}