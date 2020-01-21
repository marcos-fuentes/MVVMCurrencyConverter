package com.example.presentation.products.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.entity.RateEntity
import com.example.domain.models.entity.TransactionEntity
import com.example.domain.models.local.Product
import com.example.domain.models.local.Transaction
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.products.adapter.ProductsAdapter
import com.example.presentation.products.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.product_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.math.BigDecimal

class ProductFragment : BaseFragment() {

    private val productViewModel by viewModel<ProductViewModel>()
    private var transactionList: List<TransactionEntity?> = ArrayList()
    private var rateList: List<RateEntity?> = ArrayList()
    private var productList: ArrayList<Product> = ArrayList()
    private var productAdapter: ProductsAdapter = ProductsAdapter(context, productList)
    private lateinit var recyclerView: RecyclerView

    override fun observeViewModel() {
        productViewModel.getTransactions().observe(this, Observer {
            transactionList = it
            setProductList()
        })

        productViewModel.getRates().observe(this, Observer {
            rateList = it
            setProductList()
        })
    }


    private fun setProductList() {
        if (transactionList.isNotEmpty() && rateList.isNotEmpty()) {
            productList = getProductsFromTransaction(transactionList, rateList)
            updateRecyclerViewList()
        }
    }

    override fun getLayout(): Int {
        return R.layout.product_fragment
    }

    private fun updateRecyclerViewList() {
        productAdapter = ProductsAdapter(context, productList)
        rvProducts.layoutManager = LinearLayoutManager(context)
        rvProducts.adapter = productAdapter
        productAdapter.notifyDataSetChanged()
    }


    //TODO: MOVE THIS TO USE CASE
    private fun getProductsFromTransaction(
        transactions: List<TransactionEntity?>,
        rates: List<RateEntity?>?
    ): ArrayList<Product> {

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