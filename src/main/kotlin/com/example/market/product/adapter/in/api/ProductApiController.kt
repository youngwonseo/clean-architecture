package com.example.market.product.adapter.`in`.api

import com.example.market.product.adapter.`in`.api.request.ProductCreateRequest
import com.example.market.product.adapter.`in`.api.request.ProductUpdateRequest
import com.example.market.product.adapter.`in`.api.response.ProductResponse
import com.example.market.product.application.port.`in`.ProductCreateUseCase
import com.example.market.product.application.port.`in`.ProductDeleteUseCase
import com.example.market.product.application.port.`in`.ProductQueryUseCase
import com.example.market.product.application.port.`in`.ProductUpdateUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class ProductApiController(
    private val productQueryUseCase: ProductQueryUseCase,
    private val productCreateUseCase: ProductCreateUseCase,
    private val productUpdateUseCase: ProductUpdateUseCase,
    private val productDeleteUseCase: ProductDeleteUseCase,
) {

    @GetMapping("/api/v1/products/{id}")
    fun getOne(@PathVariable id: Long): ResponseEntity<ProductResponse> =
        productQueryUseCase.getOne(id)?.let {
            ResponseEntity.ok().body(ProductResponse(it))
        } ?: ResponseEntity.notFound().build()

    @GetMapping("/api/v1/products")
    fun getList(
        @RequestParam lastId: Long?,
        @RequestParam size: Long = 10,
    ): ResponseEntity<List<ProductResponse>> = ResponseEntity.ok().body(productQueryUseCase.getList(
        lastId = lastId,
        size = size,
    ).map {
        ProductResponse(it)
    })

    @PostMapping("/api/v1/products")
    fun create(
        @RequestBody request: ProductCreateRequest
    ): ResponseEntity<ProductResponse> = productCreateUseCase.create(
        ProductCreateUseCase.Request(
            title = request.title,
            content = request.content,
            price = request.price,
        )
    ).let {
        ResponseEntity.ok().body(ProductResponse(it))
    }

    @PutMapping("/api/v1/products/{id}")
    fun update(
        @PathVariable id: Long, @RequestBody request: ProductUpdateRequest
    ): ResponseEntity<ProductResponse> = productUpdateUseCase.update(
        id = id, request = ProductUpdateUseCase.Request(
            title = request.title,
            content = request.content,
            price = request.price,
        )
    )?.let {
        ResponseEntity.ok().body(ProductResponse(it))
    } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/api/v1/products/{id}")
    fun delete(
        @PathVariable id: Long,
    ): ResponseEntity<ProductResponse> = productDeleteUseCase.delete(id)?.let {
        ResponseEntity.ok().body(ProductResponse(it))
    } ?: ResponseEntity.notFound().build()
}
