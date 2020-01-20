package com.example.data.service.api

import androidx.lifecycle.LiveData
import com.example.data.service.api.models.response.RateResponse
import com.example.data.service.api.models.response.TransactionResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface TransactionApi {
 @GET("transactions.json")
 fun getTransaction():Call<List<TransactionResponse>>
}