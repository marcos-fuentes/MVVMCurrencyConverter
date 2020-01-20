package com.example.data.mapper.rate

import com.example.data.service.api.models.response.RateResponse
import com.example.domain.models.RateEntity

fun RateResponse.map() = RateEntity(
    from, to, rate
)
