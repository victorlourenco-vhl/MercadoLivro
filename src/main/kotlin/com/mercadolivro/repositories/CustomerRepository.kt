package com.mercadolivro.repositories

import com.mercadolivro.models.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Int> {
    fun findByNameContainingIgnoreCase(name: String): ArrayList<Customer>
}