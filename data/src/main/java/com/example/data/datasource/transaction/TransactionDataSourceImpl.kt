package com.example.data.datasource.transaction

import androidx.lifecycle.LiveData
import com.example.data.common.applyIoScheduler
import com.example.data.mapper.rate.map
import com.example.data.service.api.RateApi
import com.example.data.service.api.TransactionApi
import com.example.data.service.api.models.response.TransactionResponse
import com.example.domain.models.RateEntity
import com.example.domain.models.TransactionEntity
import io.reactivex.Single

class TransactionDataSourceImpl(private val api:TransactionApi):
    TransactionsApiDataSource {
    override fun getTransactions(): Single<List<TransactionEntity>> =
        api.getTransaction()
            .applyIoScheduler()
            .map { item -> item.map { it.map() } }
}
