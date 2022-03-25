package com.example.demo.entities

import io.ebean.annotation.DbName
import java.util.UUID
import javax.persistence.*

@Entity
@DbName("clickhouse")
@Table(name="users", schema = "default")
data class ClickUserEntity (
    @Id
    @GeneratedValue
    val id: UUID?,
    val name: String,
    val age: Int?
)

@Entity
@DbName("clickhouse")
@Table(name="users", schema = "default")
data class InsertableClickUserEntity (
    @Id
    val id: UUID? = null,
    val name: String,
    val age: Int?
)