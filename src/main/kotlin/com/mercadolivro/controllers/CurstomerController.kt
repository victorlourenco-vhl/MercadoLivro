package com.mercadolivro.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CurstomerController {

    @GetMapping
    fun msg(): String {
        return "Olá, Mundo!"
    }

}