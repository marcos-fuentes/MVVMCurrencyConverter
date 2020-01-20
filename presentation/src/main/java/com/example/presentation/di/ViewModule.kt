package com.example.presentation.di


import com.example.presentation.products.viewmodel.ProductViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ProductViewModel(get())
    }
}