package com.example.data.datasource.transaction

import androidx.lifecycle.LiveData
import com.example.data.service.api.models.response.RateResponse
import com.example.data.service.api.models.response.TransactionResponse
import com.example.domain.models.RateEntity
import com.example.domain.models.TransactionEntity
import io.reactivex.Single

interface TransactionsApiDataSource{
    fun getTransactions(): Single<List<TransactionEntity>>
}