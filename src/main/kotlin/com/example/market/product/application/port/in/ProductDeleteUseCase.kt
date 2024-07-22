package com.example.market.product.application.port.`in`

import com.example.market.product.domain.Product

interface ProductDeleteUseCase {
    fun delete(id: Long): Product?
}
