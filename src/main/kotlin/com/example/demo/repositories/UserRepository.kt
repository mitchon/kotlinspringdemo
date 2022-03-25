package com.example.demo.repositories

import com.example.demo.entities.InsertableUserEntity
import com.example.demo.entities.UserEntity
import io.ebean.Database
import io.ebean.Query
import org.springframework.stereotype.Repository


@Repository
class UserRepository (
    private val db: Database
    ) {

    private fun Database.users(): Query<UserEntity> =
        this.find(UserEntity::class.java)
            .setDisableLazyLoading(true)

    fun findAll(): List<UserEntity> = db.users().findList()

    fun insert(user: InsertableUserEntity) = db.insert(user)

}