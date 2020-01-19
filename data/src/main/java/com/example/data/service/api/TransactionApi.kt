package com.example.data.service.api

import androidx.lifecycle.LiveData
import com.example.data.service.api.models.response.RateResponse
import com.example.data.service.api.models.response.TransactionResponse
import io.reactivex.Single
import retrofit2.http.GET

interface TransactionApi {
 @GET("transaction.json")
 fun getTransaction(): LiveData<List<TransactionResponse>>
}