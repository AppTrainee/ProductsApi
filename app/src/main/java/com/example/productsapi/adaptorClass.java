package com.example.productsapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adaptorClass extends RecyclerView.Adapter<adaptorClass.ViewHolder> {

    Context context;
    List<Product> prodList;

    public adaptorClass(Context context, List<Product> dataList) {
        this.context=context;
        this.prodList=dataList;
    }

    @NonNull
    @Override
    public adaptorClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adaptorClass.ViewHolder holder, int position) {
        Product prod = prodList.get(position);
        holder.idd.setText( prod.getid());
        holder.title.setText( prod.getTitle());
        holder.descp.setText( prod.getDescription());
        holder.price.setText( prod.getPrice());
        holder.discPer.setText( prod.getDiscountPercentage());
        holder.rating.setText( prod.getRating());
        holder.stock.setText( prod.getStock());
        holder.brand.setText( prod.getBrand());
        holder.cat.setText( prod.getCategory());
        holder.thu.setText( prod.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return prodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idd, title, descp, price, discPer, rating, stock, brand, cat, thu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idd = itemView.findViewById(R.id.prodid);
            title = itemView.findViewById(R.id.titlee);
            descp = itemView.findViewById(R.id.descp);
            price = itemView.findViewById(R.id.price);
            discPer = itemView.findViewById(R.id.disc);
            rating = itemView.findViewById(R.id.rating);
            stock = itemView.findViewById(R.id.stock);
            brand = itemView.findViewById(R.id.brand);
            cat = itemView.findViewById(R.id.cat);
            thu = itemView.findViewById(R.id.thu);
        }
    }
}
