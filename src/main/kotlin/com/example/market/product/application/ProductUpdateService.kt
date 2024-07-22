package com.example.market.product.application

import com.example.market.product.application.port.`in`.ProductUpdateUseCase
import com.example.market.product.application.port.out.ProductPort
import com.example.market.product.domain.Product
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductUpdateService(
    private val productPort: ProductPort,
) : ProductUpdateUseCase {

    @Transactional
    override fun update(id: Long, request: ProductUpdateUseCase.Request): Product? {
        val product = productPort.findById(id) ?: return null
        product.update(
            title = request.title,
            content = request.content,
            price = request.price,
        )
        return productPort.save(product)
    }

}
