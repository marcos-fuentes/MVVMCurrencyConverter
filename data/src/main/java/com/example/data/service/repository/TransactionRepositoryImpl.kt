package com.example.data.service.repository


import androidx.lifecycle.LiveData
import com.example.data.service.api.RateApi
import com.example.data.service.api.TransactionApi
import com.example.data.service.api.models.response.RateResponse
import com.example.data.service.api.models.response.TransactionResponse
import org.koin.core.KoinComponent

class TransactionRepositoryImpl(private val transactionApi: TransactionApi) :TransactionsRepository{

    override fun getTransactions(): LiveData<List<TransactionResponse>> {
        return transactionApi.getTransaction()
    }

}
