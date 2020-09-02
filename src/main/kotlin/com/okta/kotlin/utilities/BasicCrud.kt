package com.okta.kotlin.utilities

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.Optional

interface BasicCrud<K, T> {
    fun getAll(pageable: Pageable): Page<T>
    fun getByiD(id: K): Optional<T>
    fun insert(document: T): T
    fun update(document: T): T
    fun deleteById(id: K): K
}