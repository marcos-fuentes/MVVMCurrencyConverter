package com.example.data.di.module


import com.example.data.service.repository.rate.RateRepositoryImpl
import com.example.data.service.repository.transaction.TransactionRepositoryImpl
import com.example.domain.repository.rate.RatesRepository
import com.example.domain.repository.transaction.TransactionsRepository
import org.koin.core.module.Module
import org.koin.dsl.module

@JvmField
val repositoryModule: Module = module {
    single<TransactionsRepository> {
        TransactionRepositoryImpl(
            get()
        )
    }
    single<RatesRepository> {
        RateRepositoryImpl(
            get()
        )
    }
}

