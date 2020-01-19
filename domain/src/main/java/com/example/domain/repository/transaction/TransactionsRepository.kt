package com.example.domain.repository.transaction

import androidx.lifecycle.LiveData
import com.example.domain.models.TransactionEntity


interface TransactionsRepository {
    fun getTransactions(): LiveData<Result<List<TransactionEntity>>>
}