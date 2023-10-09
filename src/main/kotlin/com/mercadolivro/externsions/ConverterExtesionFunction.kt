package com.mercadolivro.externsions

import com.mercadolivro.models.Customer
import com.mercadolivro.requests.PostCustomerRequest
import com.mercadolivro.requests.PutCustomerRequest

fun PostCustomerRequest.toCustomer(): Customer {
    return Customer(name = this.name, email = this.email)
}
fun PutCustomerRequest.toCustomer(id: Int): Customer {
    return Customer(id = id, name = this.name, email = this.email)
}