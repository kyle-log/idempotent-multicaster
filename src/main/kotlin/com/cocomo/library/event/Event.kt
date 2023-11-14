package com.cocomo.library.event

import com.cocomo.library.idempotent.IdempotentEvent
import com.cocomo.library.idempotent.IdempotentKey
import java.util.*

data class Event(
    val value: String,
    override val idempotentKey: IdempotentKey = IdempotentKey(UUID.randomUUID().toString()),
) : IdempotentEvent