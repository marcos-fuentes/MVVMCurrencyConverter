package com.example.data.service.api

import com.example.data.service.api.models.response.RateResponse
import retrofit2.Call
import retrofit2.http.GET

interface RateApi {
    @GET("rates.json")
    fun getRates(): Call<List<RateResponse>>
}