package com.example.domain.usecase

import androidx.lifecycle.Observer
import com.example.domain.models.entity.RateEntity
import com.example.domain.models.entity.TransactionEntity
import com.example.domain.models.local.Product
import com.example.domain.models.local.Transaction
import com.example.domain.repository.rate.RatesRepository
import com.example.domain.repository.transaction.TransactionsRepository
import java.math.BigDecimal

class ProductUseCaseImpl(
    private val ratesRepository: RatesRepository,
    private val transactionsRepository: TransactionsRepository
) : ProductUseCase {


    override fun getProducts(): List<Product> {
        val lvRates = ratesRepository.getRates()

        val lvTransactions = transactionsRepository.getTransactions()

        // return getProductsFromTransaction(null, lvRates)
        //TODO: FINISH THE IMPLEMENTATION OF USE CASE
        return ArrayList<Product>()
    }

    private fun getProductsFromTransaction(
        transactions: List<TransactionEntity?>,
        rates: List<RateEntity?>?
    ): List<Product> {

        val products: ArrayList<Product>? = ArrayList()
        transactions.forEach { transactionEntity: TransactionEntity? ->
            val product: Product =
                Product(
                    transactionEntity!!.sku,
                    //TODO: SHOULD BE DYNAMIC INSTEAD OF MOCKED
                    "EUR"
                )
            val transaction = transactionEntityToDataMapper(transactionEntity)

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

    //TODO: EXTRACT THIS MAPPER AND INJECT IT WITH KOIN
    private fun transactionEntityToDataMapper(transactionEntity: TransactionEntity): Transaction {
        return Transaction(transactionEntity.amount, transactionEntity.currency)

    }


}