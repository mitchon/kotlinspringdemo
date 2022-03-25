package com.example.demo.repositories

import com.example.demo.entities.CityEntity
import com.example.demo.entities.InsertableCityEntity
import io.ebean.Database
import io.ebean.Query
import org.springframework.stereotype.Repository

@Repository
class CityRepository (
    private val db: Database
) {

    private fun Database.cities(): Query<CityEntity> =
        this.find(CityEntity::class.java)
            .setDisableLazyLoading(true)
            .fetch("cityUsers", "name, city_id")

    fun findAll(): List<CityEntity> = db.cities().findList();

    fun insert(city: InsertableCityEntity) = db.insert(city)

}