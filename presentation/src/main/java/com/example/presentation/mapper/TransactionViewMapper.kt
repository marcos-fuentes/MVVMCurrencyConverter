package com.example.presentation.mapper

import com.example.presentation.model.TransactionUIModel

class TransactionViewMapper {
    fun mapTo(transaction: TransactionEntity): TransactionUIModel {
        return TransactionUIModel(transaction.amount, transaction.currency)
    }
}