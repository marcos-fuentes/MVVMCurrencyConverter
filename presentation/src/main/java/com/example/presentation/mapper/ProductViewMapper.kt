package com.example.presentation.mapper

import com.example.domain.models.entity.RateEntity
import com.example.domain.models.entity.TransactionEntity
import com.example.presentation.model.ProductUIModel
import java.math.BigDecimal

class ProductViewMapper(val transactionViewMapper: TransactionViewMapper) {
    fun getProductsFromTransaction(
        transactions: List<TransactionEntity?>,
        rates: List<RateEntity?>?
    ): ArrayList<ProductUIModel> {

        val products: ArrayList<ProductUIModel>? = ArrayList()
        transactions.forEach { transactionEntity: TransactionEntity? ->
            val product: ProductUIModel =
                ProductUIModel(
                    transactionEntity!!.sku,
                    //TODO: SHOULD BE DYNAMIC INSTEAD OF MOCKED
                    "EUR"
                )
            val transaction = transactionViewMapper.mapTo(transactionEntity)

            var indexOf = products!!.indexOf(product)
            if (indexOf >= 0) {
                products[indexOf].addTransaction(transaction)
            } else {
                product.addTransaction(transaction)
                products.add(product)
                indexOf = products.lastIndexOf(product)
            }

            //SUM ALL AMOUNTS
            products[indexOf].amount += getAmountInCurrency(
                rates,
                transaction.currency,
                product.currency,
                transaction.amount
            )
        }
        return products!!
    }

    private fun getAmountInCurrency(
        rates: List<RateEntity?>?,
        currencyFrom: String,
        currencyTo: String,
        amount: String
    ): BigDecimal {
        var bigDecimal = BigDecimal.ZERO

        if (rates != null) {
            if (rates.find { it!!.from == currencyFrom && it.to == currencyTo } != null) {
                var rate = rates.find { it!!.from == currencyFrom && it.to == currencyTo }!!.rate
                bigDecimal = BigDecimal(amount) * BigDecimal(rate)


                //TODO: IMPLEMENT WHAT IF THE CONVERSION IT'S NOT DIRECT (IMPLEMENT AFTER DYNAMIC CURRENCY SELECTION)
            } else {
                if (rates.find { it!!.to == currencyTo } != null) {
                    var toOfNextIt = rates.find { it!!.to == currencyTo }!!.from
                }
            }
        }

        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_EVEN)
    }
}