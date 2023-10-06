package com.mercadolivro.controllers

import com.mercadolivro.models.Customer
import com.mercadolivro.requests.PostCustomerRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CurstomerController {
    var id: Int = 0
    val customers = mutableListOf<Customer>()

    @GetMapping
    fun getCustomers(@RequestParam name: String?): List<Customer> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    @GetMapping("{id}")
    fun getCustomerById(@PathVariable id: Int): Customer? {
        return customers.find { x -> x.id == id }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest): Customer {
        id += 1
        val newCustomer = Customer(id, customer.name, customer.email)
        customers.add(newCustomer)
        return newCustomer
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: Customer) {
        customers.find { it.id == id }.let {
            it?.name = customer.name
            it?.email = customer.email
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Int) {
        customers.removeIf { it.id == id }
    }

}