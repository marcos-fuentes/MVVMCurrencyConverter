package com.example.domain.repository.rate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.models.entity.RateEntity

interface RatesRepository {
    fun getRates(): MutableLiveData<List<RateEntity?>>
}