package com.example.domain.di

import com.example.domain.usecase.rate.GetRatesUseCase
import com.example.domain.usecase.rate.GetRatesUseCaseImpl

val useCaseModule = module {
    factory<GetRatesUseCase> { GetRatesUseCaseImpl(get())}
}