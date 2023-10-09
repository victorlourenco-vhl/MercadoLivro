package com.mercadolivro.requests

import com.mercadolivro.models.Customer

data class PutCustomerRequest(
    var name: String,
    var email: String
) {

}