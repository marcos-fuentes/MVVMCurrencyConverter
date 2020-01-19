package com.example.data.datasource.rate

import androidx.lifecycle.LiveData
import com.example.data.service.api.models.response.RateResponse
import com.example.domain.models.RateEntity
import io.reactivex.Single

interface RatesApiDataSource{
    fun getRates(): Single<List<RateEntity>>
}