package com.example.data.datasource.rate

import com.example.data.common.applyIoScheduler
import com.example.data.mapper.rate.map
import com.example.data.service.api.RateApi
import com.example.domain.models.RateEntity
import io.reactivex.Single

class RateDataSourceImpl(private val api:RateApi):
    RatesApiDataSource {
    override fun getRates(): Single<List<RateEntity>> =
        api.getRates()
            .applyIoScheduler()
            .map { item -> item.map { it.map() } }


}