package com.cocomo.library.idempotent

interface IdempotentEvent {
    val idempotentKey: IdempotentKey
}

@JvmInline
value class IdempotentKey(val value: String)