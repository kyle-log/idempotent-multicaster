package com.cocomo.library.idempotent

interface IdempotentExecutor {
    fun execute(key: IdempotentKey, f: () -> Unit): Executed
}

@JvmInline
value class Executed(val executed: Boolean)
