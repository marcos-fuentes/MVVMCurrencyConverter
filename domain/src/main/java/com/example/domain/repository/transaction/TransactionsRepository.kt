package com.example.domain.repository.transaction

import androidx.lifecycle.MutableLiveData
import com.example.domain.models.entity.TransactionEntity


interface TransactionsRepository {
    fun getTransactions(): List<TransactionEntity?>
}