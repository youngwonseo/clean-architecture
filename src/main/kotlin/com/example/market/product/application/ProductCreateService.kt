package com.example.market.product.application

import com.example.market.product.application.port.`in`.ProductCreateUseCase
import com.example.market.product.application.port.out.ProductPort
import com.example.market.product.domain.Product
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductCreateService(
    private val productPort: ProductPort,
) : ProductCreateUseCase {

    @Transactional
    override fun create(request: ProductCreateUseCase.Request): Product =
        productPort.save(
            Product.create(
                title = request.title,
                content = request.content,
                price = request.price,
            )
        )
}
