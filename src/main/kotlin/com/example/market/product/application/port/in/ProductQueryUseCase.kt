package com.example.market.product.application.port.`in`

import com.example.market.product.domain.Product

interface ProductQueryUseCase {
    fun getOne(id: Long): Product?
    fun getList(lastId: Long? = null, size: Long): List<Product>
}
