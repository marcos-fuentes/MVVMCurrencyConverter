package com.example.domain.di

import com.example.domain.usecase.rate.GetRatesUseCase
import com.example.domain.usecase.rate.GetRatesUseCaseImpl
import com.example.domain.usecase.transaction.GetTransactionUseCaseImpl
import com.example.domain.usecase.transaction.GetTransactionsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetRatesUseCase> { GetRatesUseCaseImpl(get())}
    factory<GetTransactionsUseCase> { GetTransactionUseCaseImpl(get())}
}