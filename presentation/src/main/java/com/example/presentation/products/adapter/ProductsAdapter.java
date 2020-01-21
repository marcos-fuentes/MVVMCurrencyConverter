package com.example.presentation.products.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.presentation.R;
import com.example.presentation.model.ProductUIModel;


import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    Context context;
    ArrayList<ProductUIModel> products;

    public ProductsAdapter(Context context, ArrayList<ProductUIModel> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.productName.setText(products.get(position).getSku());
        holder.amount.setText(products.get(position).getAmount().toString());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView productName;
        TextView amount;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.productName);
            amount = itemView.findViewById(R.id.productAmount);


        }
    }
}
