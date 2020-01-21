package com.example.domain.models.local

import java.math.BigDecimal

class ProductEntity(
    val sku: String,
    val currency: String
)
{
    var amount: BigDecimal = BigDecimal.ZERO
    val transactionItemEntities: ArrayList<TransactionItemEntity> = ArrayList()

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is ProductEntity) return false
        return sku == other.sku
    }

    fun addTransaction(transactionItemEntity: TransactionItemEntity){
        this.transactionItemEntities.add(transactionItemEntity)
    }
}

