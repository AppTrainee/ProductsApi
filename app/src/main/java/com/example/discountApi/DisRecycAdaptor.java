package com.example.discountApi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.productsapi.R;

import java.util.ArrayList;
import java.util.List;

public class DisRecycAdaptor extends RecyclerView.Adapter<DisRecycAdaptor.DataHolder> {
    Context context;
    Intent info;
    List<DisModal> discoList;
    int pos;
    String vendorLink, prodImglink, ProductId;
    Bundle b = new Bundle();
////////////////////////////////////
public static final int total_num_items=21;
    public static final int items_per_page=7;
    public static final int items_remaining=total_num_items * items_per_page;
    public static final int last_page=total_num_items / items_per_page;
    public DisRecycAdaptor(Context context, List<DisModal> dataList) {
        this.context = context;
        this.discoList = dataList;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.products_list_layout, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        DisModal disList = discoList.get(position);
        pos = position;

        if (disList.getProduct_name() == null) {
            holder.productName.setText(disList.getBrand_name() + " " + disList.getProduct_id());
        } else {
            holder.productName.setText(disList.getProduct_name());
        }
        // vendorLink = disList.getVendor_url();
        prodImglink = disList.getProduct_image();

        Glide.with(context)
                .load(prodImglink)
                .into(holder.productImg);
        ProductId = disList.getProduct_id();

//        Intent info=new Intent(context,Ui.class);
        //  b.putSerializable("prod", (Serializable) disList);
//        info.putExtra("prod", (CharSequence) disList);

        //    context.startActivity(info);

        /* handeling null values */
//        try {
//            holder.mainImg.setText(disList.getMain_image());
//        } catch (Exception e) {
//            try {
//                throw new Exception(e);
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
//        }
    }

    @Override
    public int getItemCount() {
        return discoList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        TextView productName;
        ImageView productImg, link;

        //   Context context1;
        public DataHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.prodName);
            productImg = itemView.findViewById(R.id.productIng);

            link = itemView.findViewById(R.id.link);
            link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent link1 = new Intent();
//                    link1.setAction(Intent.ACTION_VIEW);
//                    link1.setData(Uri.parse(vendorLink));
//                    context.startActivity(link1);
                    info = new Intent(context, Ui.class);
//                    info.putExtra("prodid",ProductId);
                    info.putExtra("position", pos);
                    context.startActivity(info);


                }
            });
//            Glide.with(context)
//                    .load(prodImglink)
//                    .into(productImg);


        }

        public List<DisModal> getPage(int currentPage){
            int startItem=currentPage*items_per_page+1;
            int numOfdata=items_per_page;
            List<DisModal> pageData=new ArrayList<>();
            if(currentPage==last_page && items_remaining>0)
            {
                for(int i=startItem;i>startItem+items_remaining;i++)
                {

                }
            }else{
                for(int i=startItem;i>startItem+numOfdata;i++)
                {

                }
            }
            return pageData;
        }
    }
}
