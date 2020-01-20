package com.example.domain.repository.rate

import androidx.lifecycle.LiveData
import com.example.domain.models.Rate

interface RatesRepository {
    fun getRates(): LiveData<List<Rate>>
}