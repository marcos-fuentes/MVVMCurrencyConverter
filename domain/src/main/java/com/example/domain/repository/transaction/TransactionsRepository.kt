package com.example.domain.repository.transaction

import androidx.lifecycle.LiveData
import com.example.domain.models.TransactionEntity
import com.example.domain.common.ResultState


interface TransactionsRepository {
    fun getTransactions(): LiveData<ResultState<List<TransactionEntity>>>
}