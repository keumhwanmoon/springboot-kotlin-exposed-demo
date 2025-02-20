package com.demo.exposed

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExposedDemoApplication

fun main(args: Array<String>) {
    runApplication<ExposedDemoApplication>(*args)
}
