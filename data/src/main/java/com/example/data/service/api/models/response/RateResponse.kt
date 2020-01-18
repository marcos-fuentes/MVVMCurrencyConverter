package com.example.data.service.api.models.response

import com.google.gson.annotations.SerializedName

class RateResponse(
    @SerializedName("from") val from: String,
    @SerializedName("to") val to: String,
    @SerializedName("rate") val rate: String
)
