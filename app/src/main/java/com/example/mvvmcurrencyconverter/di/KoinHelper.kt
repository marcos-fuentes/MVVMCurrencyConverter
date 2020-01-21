package com.example.mvvmcurrencyconverter.di

import android.app.Application
import com.example.data.di.module.apiModule
import com.example.data.di.module.netModule
import com.example.data.di.module.repositoryModule
import com.example.presentation.di.viewMapperModule

import com.example.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level.DEBUG


object KoinHelper {
    @JvmStatic
    fun startKoin(application: Application) {
        startKoin {
            androidContext(application)
            androidLogger(DEBUG)
            modules(
                listOf(
                    netModule,
                    apiModule,
                    repositoryModule,
                    viewModelModule,
                    viewMapperModule
                )
            )
        }
    }
}