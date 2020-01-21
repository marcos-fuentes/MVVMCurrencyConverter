package com.example.presentation.mapper

import com.example.domain.models.local.Product
import com.example.presentation.model.ProductUIModel

class ProductViewMapper(val transactionViewMapper: TransactionViewMapper) {
    fun mapTo(product: Product): ProductUIModel {
        return ProductUIModel(
            product.sku, product.currency, product.amount,
            ArrayList(transactionViewMapper.mapTo(product.transactionEntities))
        )
    }
}