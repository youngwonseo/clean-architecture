package com.example.market.product.application

import com.example.market.product.application.port.`in`.ProductQueryUseCase
import com.example.market.product.application.port.out.ProductQueryPort
import com.example.market.product.domain.Product
import org.springframework.stereotype.Service

@Service
class ProductQueryService(
    private val productQueryPort: ProductQueryPort,
) : ProductQueryUseCase {

    override fun getOne(id: Long): Product? = productQueryPort.getOne(id)

    override fun getList(lastId: Long?, size: Long): List<Product> =
        productQueryPort.getList(lastId = lastId, size = size)
}
