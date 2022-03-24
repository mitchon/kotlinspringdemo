package com.example.demo.controllers

import com.example.demo.entities.CityEntity
import com.example.demo.entities.InsertableCityEntity
import com.example.demo.entities.UserEntity
import com.example.demo.models.Response
import com.example.demo.repositories.CityRepository
import com.example.demo.repositories.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class ApiController(val userRepo: UserRepository, val cityRepo: CityRepository) {

    @GetMapping("all")
    fun all() = "Welcome"

    @GetMapping("show")
    fun show(): Response = Response(cityRepo.findAll(), userRepo.findAll())

    @GetMapping("add/city")
    fun addCity(@RequestParam name: String) = cityRepo.insert(InsertableCityEntity(name = name))
}