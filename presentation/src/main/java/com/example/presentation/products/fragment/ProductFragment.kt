package com.example.presentation.products.fragment

import androidx.lifecycle.Observer
import com.example.domain.models.Transaction
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.products.viewmodel.ProductViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ProductFragment : BaseFragment() {

    private val productViewModel by viewModel<ProductViewModel>()
    private lateinit var productList: List<Transaction>

    override fun observeViewModel() {
        productViewModel.getTransactions().observe(this, Observer {
            productList = it
        })
    }

    override fun getLayout():Int {
        return R.layout.product_fragment
    }

    override fun bindViews() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}