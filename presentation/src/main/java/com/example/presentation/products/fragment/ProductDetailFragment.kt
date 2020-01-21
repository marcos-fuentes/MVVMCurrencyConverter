package com.example.presentation.products.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.model.ProductUIModel
import com.example.presentation.model.TransactionUIModel
import com.example.presentation.products.adapter.TransactionsAdapter
import kotlinx.android.synthetic.main.product_detail_fragment.*

class ProductDetailFragment : BaseFragment() {

    private var transactionList: ArrayList<TransactionUIModel> = ArrayList()
    //private var productAdapter: ProductsAdapter = ProductsAdapter(context, productList)

    override fun observeViewModel() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val productUIModel: ProductUIModel =
                ProductDetailFragmentArgs.fromBundle(arguments!!).productDetail

            transactionList = productUIModel.transactions
            updateRecyclerViewList()
            tv_product_name.text = productUIModel.sku
            tv_product_currency.text = productUIModel.currency.toUpperCase()
            tv_product_amount.text = productUIModel.amount.toString()
        }
    }

    override fun getLayout(): Int {
        return R.layout.product_detail_fragment
    }

    private fun updateRecyclerViewList() {
        var transactionsAdapter = TransactionsAdapter(context, transactionList)
        rvTransactions.layoutManager = LinearLayoutManager(context)
        rvTransactions.adapter = transactionsAdapter
        transactionsAdapter.notifyDataSetChanged()
    }
}