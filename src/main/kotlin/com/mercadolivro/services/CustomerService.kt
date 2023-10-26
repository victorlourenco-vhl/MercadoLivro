package com.mercadolivro.services

import com.mercadolivro.models.Customer
import com.mercadolivro.repositories.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {
    fun findByName(name: String?): List<Customer> {
        var customers: ArrayList<Customer>

        name?.let {
            customers = customerRepository.findByNameContainingIgnoreCase(name)
            return customers
        }
        return customerRepository.findAll()

    }

    fun findById(id: Int): Customer? {
        return customerRepository.findById(id).orElseThrow()
    }

    fun create(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    fun update(customer: Customer) {
        customerRepository.save(customer)
    }

    fun deleteById(id: Int) {
        customerRepository.deleteById(id)
    }

}