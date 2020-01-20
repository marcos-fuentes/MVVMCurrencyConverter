package com.example.data.mapper.rate

import com.example.data.service.api.models.response.RateResponse
import com.example.domain.models.Rate

fun RateResponse.map() = Rate(
    from, to, rate
)
