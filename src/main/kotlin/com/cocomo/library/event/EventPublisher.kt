package com.cocomo.library.event

/**
 * @author kyle.kim@daangn.com
 */
interface EventPublisher {
    fun <E : Any> publishEvent(event: E)
}