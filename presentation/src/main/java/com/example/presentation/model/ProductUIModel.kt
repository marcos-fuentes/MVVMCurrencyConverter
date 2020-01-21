package com.example.presentation.model

import com.example.domain.models.local.ProductEntity
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

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is ProductUIModel) return false
        return sku == other.sku
    }
}