package com.demo.exposed.common.config

import jakarta.annotation.PostConstruct
import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseConfig(
    @Value("\${spring.datasource.url}")
    private val url: String,

    @Value("\${spring.datasource.username}")
    private val username: String,

    @Value("\${spring.datasource.password}")
    private val password: String,

    @Value("\${spring.datasource.driver-class-name}")
    private val driverClassName: String
) {

    @PostConstruct
    fun initialize() {
        Database.connect(
            url = url,
            driver = driverClassName,
            user = username,
            password = password
        )
    }
}