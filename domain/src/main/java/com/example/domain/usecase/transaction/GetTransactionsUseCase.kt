package com.example.domain.usecase.transaction
import androidx.lifecycle.LiveData
import com.example.domain.models.RateEntity
import com.example.domain.models.TransactionEntity
import com.example.domain.network.ResultState

interface GetTransactionsUseCase {
    fun getTransactions(): LiveData<ResultState<List<TransactionEntity>>>
}