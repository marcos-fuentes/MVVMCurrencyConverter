package com.example.data.service.api

import androidx.lifecycle.LiveData
import com.example.data.service.api.models.response.RateResponse
import retrofit2.http.GET

interface RateApi {
 @GET("rates.json")
 fun getRates():LiveData<RateResponse>
}