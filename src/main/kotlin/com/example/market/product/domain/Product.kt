package com.example.market.product.domain

import java.math.BigDecimal
import java.time.LocalDateTime

class Product(
    val id: Long? = null,
    var title: String,
    var content: String,
    var price: BigDecimal,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    var deletedAt: LocalDateTime? = null,
) {

    companion object {
        fun create(
            title: String,
            content: String,
            price: BigDecimal,
        ): Product {
            val now = LocalDateTime.now()
            return Product(
                title = title,
                content = content,
                price = price,
                createdAt = now,
                updatedAt = now,
            )
        }
    }

    fun update(
        title: String,
        content: String,
        price: BigDecimal,
    ): Product {
        this.title = title
        this.content = content
        this.price = price
        this.updatedAt = LocalDateTime.now()
        return this
    }

    fun delete(): Product {
        this.deletedAt = LocalDateTime.now()
        return this
    }
}
