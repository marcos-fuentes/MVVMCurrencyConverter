package com.example.data.service.repository.transaction


import com.example.data.service.api.TransactionApi
import com.example.data.service.api.models.response.TransactionResponse
import com.example.domain.models.entity.TransactionEntity
import com.example.domain.repository.transaction.TransactionsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionRepositoryImpl(private val transactionApi: TransactionApi) :
    TransactionsRepository {

    override fun getTransactions(): List<TransactionEntity?> {
        var transactions: List<TransactionEntity?> = ArrayList()
        transactionApi.getTransaction().enqueue(object : Callback<List<TransactionResponse>> {
            override fun onFailure(call: Call<List<TransactionResponse>>, t: Throwable) {
                t.message
            }

            override fun onResponse(
                call: Call<List<TransactionResponse>>,
                response: Response<List<TransactionResponse>>
            ) {
                if (response.isSuccessful) {
                    transactions = responseToEntityMapper(response.body())
                }
            }

        })
        return transactions
    }

    //TODO: EXTRACT THIS MAPPER AND INJECT IT WITH KOIN
    private fun responseToEntityMapper(list: List<TransactionResponse>?): List<TransactionEntity?> {
        if (list != null) {
            return list.map { transactionResponse ->
                TransactionEntity(
                    transactionResponse.sku,
                    transactionResponse.amount,
                    transactionResponse.currency
                )
            }
        }
        return ArrayList()
    }
}

