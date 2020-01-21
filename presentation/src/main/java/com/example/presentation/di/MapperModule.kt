package com.example.presentation.di


import com.example.presentation.mapper.ProductViewMapper
import com.example.presentation.mapper.TransactionViewMapper
import com.example.presentation.products.viewmodel.ProductViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewMapperModule = module {
    single { ProductViewMapper(get()) }
    single { TransactionViewMapper() }
}