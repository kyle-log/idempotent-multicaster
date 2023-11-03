package com.cocomo.library.event

import org.springframework.context.ApplicationEventPublisher

class ApplicationEventPublisherAdapter(
    private val applicationEventPublisher: ApplicationEventPublisher,
) : EventPublisher {

    override fun <E : Any> publishEvent(event: E) {
        applicationEventPublisher.publishEvent(event)
    }

}