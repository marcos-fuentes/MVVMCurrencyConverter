package com.example.domain.usecase.rate

import androidx.lifecycle.LiveData
import com.example.domain.models.RateEntity
import com.example.domain.network.ResultState
import com.example.domain.repository.rate.RatesRepository

class GetRatesUseCaseImpl(
    private val ratesRepository: RatesRepository
) : GetRatesUseCase {
    override fun getRates(): LiveData<ResultState<List<RateEntity>>> {
        return ratesRepository.getRates()
    }
}