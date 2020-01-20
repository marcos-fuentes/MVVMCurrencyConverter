package com.example.data.service.repository.rate


import androidx.lifecycle.MutableLiveData
import com.example.data.service.api.RateApi
import com.example.data.service.api.models.response.RateResponse
import com.example.domain.models.entity.RateEntity
import com.example.domain.repository.rate.RatesRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RateRepositoryImpl(private val rateApi: RateApi) : RatesRepository {
    override fun getRates(): MutableLiveData<List<RateEntity?>> {
        val rates: MutableLiveData<List<RateEntity?>> = MutableLiveData()
        rateApi.getRates().enqueue(object : Callback<List<RateResponse>> {
            override fun onFailure(call: Call<List<RateResponse>>, t: Throwable) {
                t.message
            }

            override fun onResponse(
                call: Call<List<RateResponse>>,
                response: Response<List<RateResponse>>
            ) {
                if (response.isSuccessful) {
                    rates.value = responseToEntityMapper(response.body())
                }
            }

        })
        return rates
    }

    //TODO: EXTRACT THIS MAPPER AND INJECT IT WITH KOIN
    private fun responseToEntityMapper(list: List<RateResponse>?): List<RateEntity?>? {
        if (list != null) {
            return list.map { rateResponse ->
                RateEntity(
                    rateResponse.from,
                    rateResponse.to,
                    rateResponse.rate
                )
            }
        }
        return null
    }
}

