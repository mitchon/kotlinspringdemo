package com.example.demo.ebeans

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.ebean.Database
import io.ebean.DatabaseFactory
import io.ebean.config.DatabaseConfig
import org.springframework.beans.factory.FactoryBean
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.stereotype.Component

@Component
@Qualifier("clickhouse")
class ClickhouseEbeanServerFactory (
    private val mapper: ObjectMapper,
    @Value("\${app.db2.url}") val url: String,
    @Value("\${app.db2.username}") val username: String,
    @Value("\${app.db2.password}") val password: String,
) : FactoryBean<Database> {
        override fun getObject(): Database = createDatabaseConfig()

        override fun getObjectType(): Class<*>? = Database::class.java
        override fun isSingleton() = true

        fun createDatabaseConfig(): Database {
            val config = DatabaseConfig().also {
                mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                it.dataSource = DataSourceBuilder
                    .create()
                    .password(password)
                    .url(url)
                    .username(username)
                    .build()
                it.objectMapper = mapper
                it.isExpressionNativeIlike = true
                it.isDefaultServer = false
            }

            return DatabaseFactory.create(config)
        }
    }
