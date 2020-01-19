package com.example.data.service.repository.rate


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.service.api.RateApi
import com.example.data.service.api.models.response.RateResponse
import com.example.domain.models.RateEntity
import com.example.domain.repository.rate.RatesRepository

class RateRepositoryImpl(private val rateApi: RateApi) : RatesRepository {
    override fun getRates(): LiveData<List<RateEntity>> {
        return mapLiveData(rateApi.getRates())
    }
}

fun mapLiveData(liveData: LiveData<List<RateResponse>>): LiveData<List<RateEntity>> {
    return MutableLiveData(liveData.value!!.map {
        RateEntity(
            it.from,
            it.to,
            it.rate
        )
    })
}
