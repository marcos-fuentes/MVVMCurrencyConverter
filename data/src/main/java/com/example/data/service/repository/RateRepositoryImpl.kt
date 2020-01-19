package com.example.data.service.repository


import androidx.lifecycle.LiveData
import com.example.data.service.api.RateApi
import com.example.data.service.api.models.response.RateResponse
import org.koin.core.KoinComponent

class RateRepositoryImpl(private val rateApi: RateApi) :RatesRepository{

    override fun getRates(): LiveData<List<RateResponse>> {
        return rateApi.getRates();
    }

}
