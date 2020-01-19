package com.example.data.service.repository

import androidx.lifecycle.LiveData
import com.example.data.service.api.models.response.RateResponse
import com.example.data.service.api.models.response.TransactionResponse

interface TransactionsRepository{
    fun getTransactions():LiveData<List<TransactionResponse>>
}