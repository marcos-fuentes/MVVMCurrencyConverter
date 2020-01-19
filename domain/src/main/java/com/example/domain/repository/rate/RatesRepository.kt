package com.example.domain.repository.rate

import androidx.lifecycle.LiveData
import com.example.domain.models.RateEntity

interface RatesRepository {
    fun getRates(): LiveData<Result<List<RateEntity>>>
}