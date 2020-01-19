package com.example.data.mapper.rate

import com.example.data.service.api.models.response.TransactionResponse
import com.example.domain.models.TransactionEntity

fun TransactionEntity.map() = TransactionResponse(
    sku, amount, currency
)