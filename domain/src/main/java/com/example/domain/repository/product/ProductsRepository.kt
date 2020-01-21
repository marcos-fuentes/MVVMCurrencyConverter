package com.example.domain.repository.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.models.entity.RateEntity
import com.example.domain.models.local.Product
import io.reactivex.Single

interface ProductsRepository {
    fun getProducts(): MutableLiveData<List<Product?>>
}