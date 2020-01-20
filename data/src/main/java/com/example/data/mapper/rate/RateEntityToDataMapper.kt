package com.example.data.mapper.rate

import com.example.data.service.api.models.response.RateResponse
import com.example.domain.models.RateEntity


fun RateEntity.map() = RateResponse(
       from, to, rate
)