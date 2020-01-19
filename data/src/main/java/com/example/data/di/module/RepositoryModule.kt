package com.example.data.di.module


import com.example.data.service.api.models.response.RateResponse
import com.example.data.service.repository.RateRepositoryImpl
import com.example.data.service.repository.RatesRepository
import com.example.data.service.repository.TransactionRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

@JvmField
val repositoryModule: Module = module {
    single<TransactionRepositoryImpl> {TransactionRepositoryImpl(get())}
    single<RatesRepository> { RateRepositoryImpl(get()) }
}

