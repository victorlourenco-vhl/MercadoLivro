package com.mercadolivro.controllers

import com.mercadolivro.externsions.toCustomer
import com.mercadolivro.models.Customer
import com.mercadolivro.requests.PostCustomerRequest
import com.mercadolivro.requests.PutCustomerRequest
import com.mercadolivro.services.CustomerService
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
class CurstomerController(
    val customerService: CustomerService
) {

    @GetMapping
    fun getCustomers(@RequestParam name: String?): List<Customer> {
        return customerService.getCustomers(name)
    }

    @GetMapping("{id}")
    fun getCustomerById(@PathVariable id: Int): Customer? {
        return customerService.getCustomerById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody postCustomer: PostCustomerRequest): Customer {
        return customerService.create(postCustomer.toCustomer())
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody putCustomer: PutCustomerRequest) {

        customerService.update(putCustomer.toCustomer(id))
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Int) {
        customerService.deleteById(id)
    }

}