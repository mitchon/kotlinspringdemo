package com.example.demo.ebeans

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.ebean.Database
import io.ebean.DatabaseFactory
import org.springframework.beans.factory.FactoryBean
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import javax.sql.DataSource
import io.ebean.config.DatabaseConfig

@Component
@Primary
class EbeanServerFactory(
    private val mapper: ObjectMapper,
    private val dataSource: DataSource
): FactoryBean<Database> {
    override fun getObject(): Database = createDatabaseConfig()

    override fun getObjectType(): Class<*>? = Database::class.java
    override fun isSingleton() = true

    fun createDatabaseConfig(): Database {
        val config = DatabaseConfig().also {
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            it.dataSource = dataSource
            it.objectMapper = mapper
            it.isExpressionNativeIlike = true
            it.isDefaultServer = true
        }

        return DatabaseFactory.create(config)
    }
}