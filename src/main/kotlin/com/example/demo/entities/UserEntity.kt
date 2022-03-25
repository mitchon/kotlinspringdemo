package com.example.demo.entities

import java.util.UUID
import javax.persistence.*

@Entity
@Table(name="users", schema = "master_schema")
data class UserEntity (
        @Id
        @GeneratedValue
        val id: UUID?,
        val name: String,
        val city_id: UUID?
        )

@Entity
@Table(name="users", schema = "master_schema")
data class InsertableUserEntity (
        @Id
        val id: UUID? = null,
        val name: String,
        val city_id: UUID?
)