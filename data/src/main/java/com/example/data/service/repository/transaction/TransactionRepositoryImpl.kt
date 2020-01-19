package com.example.data.service.repository.transaction


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.service.api.TransactionApi
import com.example.data.service.api.models.response.TransactionResponse
import com.example.domain.models.TransactionEntity
import com.example.domain.repository.transaction.TransactionsRepository

class TransactionRepositoryImpl(private val transactionApi: TransactionApi) :
    TransactionsRepository {

    override fun getTransactions(): LiveData<List<TransactionEntity>> {
        return mapLiveData(transactionApi.getTransaction())
    }

    fun mapLiveData(liveData: LiveData<List<TransactionResponse>>): LiveData<List<TransactionEntity>> {
        return MutableLiveData(liveData.value!!.map {
            TransactionEntity(
                it.sku,
                it.amount,
                it.currency
            )
        })
    }


}
