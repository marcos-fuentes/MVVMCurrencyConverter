package com.example.presentation.products.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.Transaction
import com.example.domain.repository.transaction.TransactionsRepository

class ProductViewModel(private val transactionsRepository: TransactionsRepository) : ViewModel() {
    private lateinit var lvTransactions: MutableLiveData<List<Transaction>>

    init {
        configLiveDataResponse()
    }

    private fun configLiveDataResponse() {
        lvTransactions =
            transactionsRepository.getTransactions() as MutableLiveData<List<Transaction>>
    }

    public fun getTransactions(): LiveData<List<Transaction>> {
        return lvTransactions
    }

}