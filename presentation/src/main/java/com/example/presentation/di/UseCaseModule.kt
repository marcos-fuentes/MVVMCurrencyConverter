package com.example.presentation.di


import com.example.domain.usecase.ProductUseCase
import com.example.domain.usecase.ProductUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<ProductUseCase> {
        ProductUseCaseImpl(get(), get())
    }
}
