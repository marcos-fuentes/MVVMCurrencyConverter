package com.example.mvvmcurrencyconverter

import android.app.Application
import com.example.mvvmcurrencyconverter.di.KoinHelper.startKoin

class CurrencyConversionApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this)

    }


}