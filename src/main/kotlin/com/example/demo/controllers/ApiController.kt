package com.example.demo.controllers

import com.example.demo.repositories.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class ApiController (val userRepo: UserRepository) {
    @GetMapping("all")
    fun all() = "Welcome"
    @GetMapping("show")
    fun show() = userRepo.findAll()
}