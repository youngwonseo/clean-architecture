package com.example.market.product.adapter.`in`.api.response

import com.example.market.product.domain.Product
import java.math.BigDecimal

data class ProductResponse(
    val id: Long,
    val title: String,
    val content: String,
    val price: BigDecimal,
) {
    constructor(product: Product) : this(
        id = product.id!!,
        title = product.title,
        content = product.content,
        price = product.price,
    )
}
