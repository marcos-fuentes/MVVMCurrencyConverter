package com.example.presentation.products.fragment

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.entity.RateEntity
import com.example.domain.models.entity.TransactionEntity
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.mapper.ProductViewMapper
import com.example.presentation.model.ProductUIModel
import com.example.presentation.products.adapter.ProductsAdapter
import com.example.presentation.products.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.product_fragment.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ProductFragment : BaseFragment() {

    private val productViewModel by viewModel<ProductViewModel>()
    private val productViewMapper: ProductViewMapper by inject()

    private var transactionList: List<TransactionEntity?> = ArrayList()
    private var rateList: List<RateEntity?> = ArrayList()
    private var productList: ArrayList<ProductUIModel> = ArrayList()
    private var productAdapter: ProductsAdapter = ProductsAdapter(context, productList)

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
            productList = productViewMapper.getProductsFromTransaction(transactionList, rateList)
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
}