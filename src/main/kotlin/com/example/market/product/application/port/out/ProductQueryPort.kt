package com.example.market.product.application.port.out

import com.example.market.product.domain.Product

interface ProductQueryPort {
    fun getOne(id: Long): Product?
    fun getList(lastId: Long?, size: Long): List<Product>
}
