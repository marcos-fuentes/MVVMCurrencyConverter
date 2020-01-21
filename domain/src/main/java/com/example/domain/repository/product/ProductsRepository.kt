package com.example.domain.repository.product

import androidx.lifecycle.MutableLiveData
import com.example.domain.models.local.ProductEntity

interface ProductsRepository {
    fun getProducts(): MutableLiveData<List<ProductEntity?>>
}