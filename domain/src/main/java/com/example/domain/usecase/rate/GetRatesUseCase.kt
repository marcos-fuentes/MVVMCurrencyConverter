package com.example.domain.usecase.rate
import androidx.lifecycle.LiveData
import com.example.domain.models.RateEntity
import com.example.domain.network.ResultState

interface GetRatesUseCase {
    fun getRates(): LiveData<ResultState<List<RateEntity>>>
}