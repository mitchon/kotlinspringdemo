package com.example.demo.models

import com.example.demo.entities.CityEntity
import com.example.demo.entities.ClickUserEntity
import com.example.demo.entities.UserEntity

data class Response (
    val cities: List<CityEntity>,
    val users: List<UserEntity>,
    val cusers: List<ClickUserEntity>
)
