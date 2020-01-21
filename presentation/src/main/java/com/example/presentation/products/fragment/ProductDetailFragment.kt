package com.example.presentation.products.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.models.entity.RateEntity
import com.example.domain.models.entity.TransactionEntity
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.model.ProductUIModel
import com.example.presentation.model.TransactionUIModel
import kotlinx.android.synthetic.main.product_fragment.*

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
        }
    }


    private fun setProductList() {
        if (transactionList.isNotEmpty() && rateList.isNotEmpty()) {
            // productList = productViewMapper.getProductsFromTransaction(transactionList, rateList)
            updateRecyclerViewList()
        }
    }

    override fun getLayout(): Int {
        return R.layout.product_detail_fragment
    }

    private fun updateRecyclerViewList() {
        //productAdapter = ProductsAdapter(context, productList)
        rvProducts.layoutManager = LinearLayoutManager(context)
        //   rvProducts.adapter = productAdapter
        //   productAdapter.notifyDataSetChanged()
    }
}