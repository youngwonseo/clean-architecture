package com.example.market.product.application.port.`in`

import com.example.market.product.domain.Product
import java.math.BigDecimal

interface ProductUpdateUseCase {
    fun update(
        id: Long,
        request: Request
    ): Product?

    data class Request(
        val title: String,
        val content: String,
        val price: BigDecimal,
    )
}
