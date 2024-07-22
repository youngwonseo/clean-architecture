package com.example.market.product.adapter.out.persistence

import com.example.market.product.application.port.out.ProductQueryPort
import com.example.market.product.domain.Product
import org.springframework.stereotype.Component

@Component
class ProductQueryAdapter(
    private val productRepository: ProductRepository,
) : ProductQueryPort {

    override fun getOne(id: Long): Product? = TODO()

    override fun getList(lastId: Long?, size: Long): List<Product> =
        productRepository.findAll(
            cursor = lastId,
            size = size
        ).map {
            it.toDomain()
        }
}
