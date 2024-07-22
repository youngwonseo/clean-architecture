package com.example.market.product.adapter.out.persistence

import com.example.market.product.domain.Product
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
class ProductEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    var title: String,
    var content: String,
    var price: BigDecimal,
    var createdAt: LocalDateTime,
    var updatedAt: LocalDateTime,
    var deletedAt: LocalDateTime? = null,
) {

    fun toDomain(): Product =
        Product(
            id = this.id,
            title = this.title,
            content = this.content,
            price = this.price,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt,
            deletedAt = this.deletedAt,
        )
}
