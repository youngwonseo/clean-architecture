package com.example.market.config

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import kotlin.reflect.KClass

@Repository
abstract class CustomQuerydslRepositorySupport
    (clazz: KClass<*>) : QuerydslRepositorySupport(clazz.java) {
    @PersistenceContext
    override fun setEntityManager(entityManager: EntityManager) {
        super.setEntityManager(entityManager)
    }
}
