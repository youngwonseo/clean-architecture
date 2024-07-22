package com.example.market.product.adapter.out.persistence

import com.example.market.product.application.port.out.ProductPort
import com.example.market.product.domain.Product
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ProductAdapter(
    private val productRepository: ProductRepository,
) : ProductPort {

    override fun findById(id: Long): Product? =
        productRepository.findByIdOrNull(id)?.toDomain()

    override fun save(product: Product): Product =
        productRepository.save(
            ProductEntity(
                id = product.id,
                title = product.title,
                content = product.content,
                price = product.price,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt,
                deletedAt = product.deletedAt,
            )
        ).toDomain()

}
