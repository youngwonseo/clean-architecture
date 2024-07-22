package com.example.market.product.application.port.out

import com.example.market.product.domain.Product

interface ProductPort {
    fun findById(id: Long): Product?
    fun save(product: Product): Product
}
