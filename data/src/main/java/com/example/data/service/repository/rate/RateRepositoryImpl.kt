package com.example.data.service.repository.rate


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.service.api.RateApi
import com.example.data.service.api.models.response.RateResponse
import com.example.domain.models.Rate
import com.example.domain.repository.rate.RatesRepository

class RateRepositoryImpl(private val rateApi: RateApi) : RatesRepository {
    override fun getRates(): LiveData<List<Rate>> {
        return mapLiveData(rateApi.getRates())
    }


fun mapLiveData(liveData: LiveData<List<RateResponse>>): LiveData<List<Rate>> {
    return MutableLiveData(liveData.value!!.map {
        Rate(
            it.from,
            it.to,
            it.rate
        )
    })
}
}
