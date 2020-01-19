package com.example.data.mapper.rate

import com.example.data.service.api.models.response.RateResponse
import com.example.data.service.api.models.response.TransactionResponse
import com.example.domain.models.RateEntity
import com.example.domain.models.TransactionEntity

fun TransactionResponse.map() = TransactionEntity(
    sku, amount, currency
)
