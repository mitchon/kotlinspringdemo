package com.example.demo.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "cities", schema = "master_schema")
data class CityEntity (
    @Id
    @GeneratedValue
    val id : UUID,
    val name: String,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    @JoinColumn(name="city_id", referencedColumnName = "id")
    val cityUsers: List<UserEntity>
    )

