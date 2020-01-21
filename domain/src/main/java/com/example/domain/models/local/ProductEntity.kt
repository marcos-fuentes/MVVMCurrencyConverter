package com.example.domain.models.local

import java.math.BigDecimal

class ProductEntity(
    val sku: String,
    val currency: String
)
{
    var amount: BigDecimal = BigDecimal.ZERO
    val transactionEntities: ArrayList<TransactionEntity> = ArrayList()

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is ProductEntity) return false
        return sku == other.sku
    }

    fun addTransaction(transactionEntity: TransactionEntity){
        this.transactionEntities.add(transactionEntity)
    }
}

