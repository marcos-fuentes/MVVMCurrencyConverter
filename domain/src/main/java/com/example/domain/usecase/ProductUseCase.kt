package com.example.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.domain.models.local.Product

interface ProductUseCase {
    fun getProducts(): List<Product>
}