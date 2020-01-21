package com.example.presentation.products.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.R
import com.example.presentation.model.TransactionUIModel
import kotlinx.android.synthetic.main.transaction_item.view.*
import java.util.*

class TransactionsAdapter(
    var context: Context?,
    var transactions: ArrayList<TransactionUIModel>
) : RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.transaction_item, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(transactions[position])
    }


    override fun getItemCount(): Int {
        return transactions.size
    }

    inner class TransactionViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(transactionUIModel: TransactionUIModel) {
            itemView.transactionAmount.text = transactionUIModel.amount.toString()
            itemView.transactionCurrency.text = transactionUIModel.currency
        }
    }


}