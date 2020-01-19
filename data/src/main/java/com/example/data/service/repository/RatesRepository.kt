package com.example.data.service.repository

import androidx.lifecycle.LiveData
import com.example.data.service.api.models.response.RateResponse

interface RatesRepository{
    fun getRates():LiveData<List<RateResponse>>
}