package com.example.market.product.application

import com.example.market.product.application.port.`in`.ProductDeleteUseCase
import com.example.market.product.application.port.out.ProductPort
import com.example.market.product.domain.Product
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductDeleteService(
    private val productPort: ProductPort,
) : ProductDeleteUseCase {

    @Transactional
    override fun delete(id: Long): Product? {
        val product = productPort.findById(id) ?: return null

        product.delete()
        return productPort.save(product)
    }
}
