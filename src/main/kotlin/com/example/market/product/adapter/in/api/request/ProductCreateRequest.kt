package com.example.market.product.adapter.`in`.api.request

import java.math.BigDecimal

data class ProductCreateRequest(
    val title: String,
    val content: String,
    val price: BigDecimal,
) {
}
