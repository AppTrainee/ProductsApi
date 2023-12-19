package com.example.discountApi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.productsapi.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ui extends AppCompatActivity {
    Context context;
    TextView red1;
    String url = "https://www.afsupply.com//media//catalog//product//M//O//MOE14718_1.jpg";
    ImageView cardimg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        cardimg1 = findViewById(R.id.cardimg1);
        red1 = findViewById(R.id.red1);

        Glide.with(this)
                .load(url)
                .into(cardimg1);

    }
}