package com.example.market.product.application

import com.example.market.product.application.port.`in`.ProductCreateUseCase
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.math.BigDecimal

@SpringBootTest
class ProductQueryServiceTests @Autowired constructor(
    private val productQueryService: ProductQueryService,
    private val productCreateService: ProductCreateService,
) : FreeSpec({

    beforeTest {
        for (i in 0 until 10) {
            productCreateService.create(
                ProductCreateUseCase.Request(
                    title = "title$i",
                    content = "content$i",
                    price = BigDecimal(1000)
                )
            )
        }
    }

    "cursor pagination" {
        val list = productQueryService.getList(lastId = 5, size = 3)
        list.firstOrNull()?.id shouldBe 4
        list.size shouldBe 3
    }
})
