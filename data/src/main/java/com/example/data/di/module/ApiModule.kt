package com.example.data.di.module


import com.example.data.service.api.RateApi
import com.example.data.service.api.TransactionApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single { get<Retrofit>().create(RateApi::class.java) }
    single { get<Retrofit>().create(TransactionApi::class.java) }
}