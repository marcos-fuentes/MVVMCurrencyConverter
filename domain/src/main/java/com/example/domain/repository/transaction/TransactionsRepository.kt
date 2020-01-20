package com.example.domain.repository.transaction

import androidx.lifecycle.MutableLiveData
import com.example.domain.models.TransactionEntity


interface TransactionsRepository {
    fun getTransactions(): MutableLiveData<List<TransactionEntity?>>
}