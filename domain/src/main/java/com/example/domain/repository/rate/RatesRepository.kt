package com.example.domain.repository.rate

import androidx.lifecycle.LiveData
import com.example.domain.models.RateEntity
import com.example.domain.network.ResultState

interface RatesRepository {
    fun getRates(): LiveData<ResultState<List<RateEntity>>>
}