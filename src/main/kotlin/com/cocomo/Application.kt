package com.cocomo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringIdempotentMulticasterApplication

fun main(args: Array<String>) {
    runApplication<SpringIdempotentMulticasterApplication>(*args)
}
