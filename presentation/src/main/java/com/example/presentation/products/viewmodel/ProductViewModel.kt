package com.example.presentation.products.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.entity.RateEntity
import com.example.domain.models.entity.TransactionEntity
import com.example.domain.repository.rate.RatesRepository
import com.example.domain.repository.transaction.TransactionsRepository

class ProductViewModel(private val repository: TransactionsRepository,
                       private val ratesRepository: RatesRepository) : ViewModel() {
    private var lvRates: MutableLiveData<List<RateEntity?>> = MutableLiveData()
    private var lvTransactions: MutableLiveData<List<TransactionEntity?>> = MutableLiveData()

    init {
        configLiveDataResponse()
    }

    private fun configLiveDataResponse() {
        lvTransactions = repository.getTransactions()
        lvRates = ratesRepository.getRates()
    }

    fun getRates(): MutableLiveData<List<RateEntity?>> {
        return lvRates
    }

    fun getTransactions(): MutableLiveData<List<TransactionEntity?>> {
        return lvTransactions
    }
}