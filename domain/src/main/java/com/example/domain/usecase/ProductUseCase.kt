package com.example.domain.usecase

import com.example.domain.models.local.ProductEntity

interface ProductUseCase {
    fun getProducts(): List<ProductEntity>
}