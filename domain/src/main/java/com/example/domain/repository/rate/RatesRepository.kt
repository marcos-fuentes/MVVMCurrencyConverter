package com.example.domain.repository.rate

import androidx.lifecycle.LiveData
import com.example.domain.models.entity.RateEntity

interface RatesRepository {
    fun getRates(): LiveData<List<RateEntity>>
}