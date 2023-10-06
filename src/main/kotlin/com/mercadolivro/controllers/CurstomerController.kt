package com.mercadolivro.controllers

import com.mercadolivro.models.Customer
import com.mercadolivro.requests.PostCustomerRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CurstomerController {
    var id: Int = 0
    val customers = mutableListOf<Customer>()

    @GetMapping
    fun getCustomer(): List<Customer> {
        return customers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest): Customer {
        id += 1
        val newCustomer = Customer(id, customer.name, customer.email)
        customers.add(newCustomer)
        return newCustomer
    }

}