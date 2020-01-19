package com.example.domain.usecase.transaction

import androidx.lifecycle.LiveData
import com.example.domain.models.TransactionEntity
import com.example.domain.common.ResultState

interface GetTransactionsUseCase {
    fun getTransactions(): LiveData<ResultState<List<TransactionEntity>>>
}