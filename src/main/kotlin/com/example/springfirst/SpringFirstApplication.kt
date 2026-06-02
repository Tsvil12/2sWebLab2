package com.example.springfirst

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SpringFirstApplication

fun main(args: Array<String>) {
    runApplication<SpringFirstApplication>(*args)
}