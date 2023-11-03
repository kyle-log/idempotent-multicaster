package com.cocomo.library.idempotent

/**
 * @author kyle.kim@daangn.com
 */
interface IdempotentEvent {
    val uuid: String
}