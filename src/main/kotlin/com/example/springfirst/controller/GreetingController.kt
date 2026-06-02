package com.example.springfirst.controller

import com.example.springfirst.dto.GreetingMain
import com.example.springfirst.dto.GreetingUser
import com.example.springfirst.dto.UserData
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

@RestController
@RequestMapping("/greeting")
class GreetingController {

    private val userStorage = ConcurrentHashMap<UUID, UserData>()

    @GetMapping
    fun getGreeting(@RequestParam(required = false) id: UUID?): ResponseEntity<*> {
        return if (id == null) {
            ResponseEntity.ok(GreetingMain("Hello World"))
        } else {
            val user = userStorage[id]
            if (user != null) {
                ResponseEntity.ok(user)
            } else {
                ResponseEntity.status(HttpStatus.NOT_FOUND).build<Any>()
            }
        }
    }

    @PostMapping
    fun createUser(@RequestBody userData: UserData): GreetingUser {
        val id = UUID.randomUUID()
        userStorage[id] = userData
        return GreetingUser(
            text = "Hello, ${userData.surname} ${userData.name}",
            id = id
        )
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: UUID): ResponseEntity<UserData> {
        val user = userStorage[id]
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}