package com.mercadolivro.controllers

import com.mercadolivro.models.Customer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CurstomerController {

    @GetMapping
    fun getCustomer(): Customer {
        return Customer(1, "James Gosling", "james.gosling@oracle.com")
    }

}