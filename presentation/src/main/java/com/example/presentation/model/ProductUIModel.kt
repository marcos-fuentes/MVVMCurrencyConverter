package com.example.presentation.model

import com.example.domain.models.local.Transaction
import java.io.Serializable
import java.math.BigDecimal

class ProductUIModel(
    val sku: String,
    val currency: String,
    var amount: BigDecimal = BigDecimal.ZERO,
    val transactions: ArrayList<TransactionUIModel> = ArrayList()
) : Serializable {

    fun addTransaction(transactionEntity: TransactionUIModel) {
        this.transactions.add(transactionEntity)
    }
}