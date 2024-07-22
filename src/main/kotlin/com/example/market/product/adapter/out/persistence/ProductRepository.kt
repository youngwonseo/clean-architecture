package com.example.market.product.adapter.out.persistence

import com.example.market.config.CustomQuerydslRepositorySupport
import com.example.market.product.domain.Product
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, Long>, ProductSupport

interface ProductSupport {
    fun findOne(id: Long): ProductEntity?
    fun findAll(cursor: Long?, size: Long): List<ProductEntity>
}

class ProductSupportImpl(
    private val query: JPAQueryFactory,
) : CustomQuerydslRepositorySupport(Product::class), ProductSupport {

    val product: QProductEntity = QProductEntity.productEntity

    override fun findOne(id: Long): ProductEntity? =
        query
            .selectFrom(product)
            .where(
                product.id.eq(id).and(
                    product.deletedAt.isNull
                )
            ).fetchOne()

    override fun findAll(cursor: Long?, size: Long): List<ProductEntity> =
        query
            .selectFrom(product)
            .where(
                product.deletedAt.isNull.and(
                    if (cursor == null) null else product.id.lt(cursor)
                )
            ).limit(size)
            .orderBy(product.id.desc())
            .fetch()
}
