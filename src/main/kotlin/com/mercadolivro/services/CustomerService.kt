package com.mercadolivro.services

import com.mercadolivro.models.Customer
import com.mercadolivro.requests.PostCustomerRequest
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

@Service
class CustomerService {

    val customers = mutableListOf<Customer>()

    var id: Int = 0

    fun getCustomers(name: String?): List<Customer> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun getCustomerById(id: Int): Customer? {
        return customers.find { x -> x.id == id }
    }

    fun create(customer: Customer): Customer {
        id += 1
        val newCustomer = Customer(id, customer.name, customer.email)
        customers.add(newCustomer)
        return newCustomer
    }

    fun update(customer: Customer) {
        customers.find { it.id == customer.id }.let {
            it?.name = customer.name
            it?.email = customer.email
        }
    }

    fun deleteById(id: Int) {
        customers.removeIf { it.id == id }
    }

}