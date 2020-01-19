package com.example.domain.usecase.transaction

import androidx.lifecycle.LiveData
import com.example.domain.common.ResultState
import com.example.domain.models.TransactionEntity
import com.example.domain.repository.transaction.TransactionsRepository

class GetTransactionUseCaseImpl(
    private val transactionsRepository: TransactionsRepository
) : GetTransactionsUseCase {
    override fun getTransactions(): LiveData<ResultState<List<TransactionEntity>>> {
        return transactionsRepository.getTransactions()
    }
}