package com.example.domain.models.local

import com.example.domain.models.entity.TransactionEntity
import java.math.BigDecimal

class Product(
    val sku: String,
    val currency: String
)
{
    var amount: BigDecimal = BigDecimal.ZERO
    private val transactionEntities: ArrayList<Transaction> = ArrayList()

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Product) return false
        return sku == other.sku
    }

    fun addTransaction(transactionEntity: Transaction){
        this.transactionEntities.add(transactionEntity)
    }
}

