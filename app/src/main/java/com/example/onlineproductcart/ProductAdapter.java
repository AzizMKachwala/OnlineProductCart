package com.example.onlineproductcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.DataViewHolder> {

    List<Product> productList, searchModels;
    Context context;
    TextView totalItemsTextView;
    int totalItems = 0;

    public ProductAdapter(Context context, List<Product> productList, TextView totalItemsTextView) {
        this.productList = productList;
        this.context = context;
        this.searchModels = productList;
        this.totalItemsTextView = totalItemsTextView;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.product_item_data, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        Product product = searchModels.get(position);

        try {
            Glide
                    .with(context)
                    .load(product.getImage())
                    .apply(new RequestOptions().placeholder(R.drawable.baseline_downloading_24))
                    .error(R.drawable.nodata)
                    .into(holder.imgProduct);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.productNameTextView.setText(product.getName());
        holder.productDetailTextView.setText(product.getDetails());
        holder.productPriceTextView.setText("₹" + String.valueOf(product.getPrice()));

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalItems++;
                totalItemsTextView.setText("Total Items: " + totalItems);
                holder.removeButton.setVisibility(View.VISIBLE);
                holder.addButton.setVisibility(View.GONE);
            }
        });
        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalItems--;
                totalItemsTextView.setText("Total Items: " + totalItems);
                holder.removeButton.setVisibility(View.GONE);
                holder.addButton.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return searchModels.size();
    }

    public void search(CharSequence charSequence, TextView lytProduct, RecyclerView productRecyclerView) {

        try {
            String charString = charSequence.toString().trim();
            if (charString.isEmpty()) {
                searchModels = productList;
                productRecyclerView.setVisibility(View.VISIBLE);
            } else {
                int flag = 0;
                List<Product> filteredList = new ArrayList<>();
                for (Product row : productList) {
                    if (row.getName().toLowerCase().contains(charString.toLowerCase())) {
                        filteredList.add(row);
                        flag = 1;
                    }
                }
                if (flag == 1) {
                    searchModels = filteredList;
                    productRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    productRecyclerView.setVisibility(View.GONE);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {

        TextView productNameTextView, productDetailTextView, productPriceTextView;
        ImageView imgProduct;
        Button addButton, removeButton;
        int TotalPrice = 0;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            productNameTextView = itemView.findViewById(R.id.txtproductName);
            productDetailTextView = itemView.findViewById(R.id.txtproductDetail);
            productPriceTextView = itemView.findViewById(R.id.txtproductPrice);
            addButton = itemView.findViewById(R.id.btnAdd);
            removeButton = itemView.findViewById(R.id.btnRemove);
        }
    }
}
