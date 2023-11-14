package com.cocomo.library.idempotent

import org.springframework.cache.Cache
import org.springframework.cache.CacheManager

class StandardIdempotentExecutor(
    val cacheManager: CacheManager,
) : IdempotentExecutor {

    private val cache: Cache by lazy {
        cacheManager.getCache("idempotent-executor") ?: throw IllegalStateException("Cache not ready")
    }

    override fun execute(key: IdempotentKey, f: () -> Unit): Executed {
        return if (alreadyProcessed(key)) {
            println("Skipped. key: $key")
            Executed(false)
        } else {
            f()
            put(key)
            Executed(true)
        }
    }

    private fun alreadyProcessed(key: IdempotentKey): Boolean {
        return get(key) != null
    }

    private fun get(key: IdempotentKey): CacheValue? = runCatching {
        cache.get(key.value, CacheValue::class.java)
    }.getOrElse {
        println("Failed to get cache. key: $key")
        null
    }

    private fun put(key: IdempotentKey) = runCatching {
        cache.put(key.value, value)
    }.getOrElse {
        println("Failed to put cache. key: $key")
        null
    }

    companion object {
        private val value = CacheValue("1")
    }
}

data class CacheValue(val value: String)