package com.example.data.service.api.models.response

import com.google.gson.annotations.SerializedName

class TransactionResponse (
    @SerializedName("sku") val sku:String,
    @SerializedName("amount") val amount:String,
    @SerializedName("currency") val currency:String
)