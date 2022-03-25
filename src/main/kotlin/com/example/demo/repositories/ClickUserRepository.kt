package com.example.demo.repositories

import com.example.demo.entities.ClickUserEntity
import com.example.demo.entities.InsertableClickUserEntity
import io.ebean.Database
import io.ebean.Query
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository
import javax.annotation.PostConstruct


@Repository
class ClickUserRepository (
    @Qualifier("clickhouse") private val db: Database
) {
    @PostConstruct
    fun debug() {
        println(db.platform.name)
    }

    private fun Database.cusers(): Query<ClickUserEntity> =
        this.find(ClickUserEntity::class.java)
            .setDisableLazyLoading(true)

    fun findAll(): List<ClickUserEntity> = db.cusers().findList()

    fun insert(user: InsertableClickUserEntity) = db.insert(user)
}