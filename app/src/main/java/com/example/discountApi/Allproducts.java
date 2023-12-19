package com.example.discountApi;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.productsapi.R;

import java.security.cert.CertificateException;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Allproducts extends AppCompatActivity {
    private ProgressBar pg;
    private ProgressDialog progressDialog;

    DiscountInterface discountInterface;
    List<DisModal> dataList;
    private RecyclerView discountrecycler;
    DisRecycAdaptor disRecycAdaptor;
    Button next,prev;
    Paginator p=new Paginator();
    private int totalPages=Paginator.total_num_items/Paginator.items_per_page;
    private int currentPage=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allproducts);
        discountrecycler = findViewById(R.id.Disrecycler);
        next=findViewById(R.id.next);
        prev=findViewById(R.id.prev);


        pg = findViewById(R.id.allprodProgress);
        pg.setVisibility(View.VISIBLE);

//        progressDialog=new ProgressDialog(this);
//        progressDialog.setMessage("Loading");
//        progressDialog.setTitle("Plant");
//        progressDialog.create();
//        progressDialog.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pg.setVisibility(View.GONE);
//                progressDialog.dismiss();
            }
        }, 2000);
        retrofitFun("8390");
    }

    private void retrofitFun(String dataId) {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://phplaravel-882494-3459554.cloudwaysapps.com/").addConverterFactory(GsonConverterFactory.create()).client(getUnsafeOkHttpClient()).build();
//        discountInterface = retrofit.create(DiscountInterface.class);
        RetrofitInstance.getInstance().discountInterface.getData(Integer.parseInt(dataId)).enqueue(new Callback<List<DisModal>>() {
            @Override
            public void onResponse(Call<List<DisModal>> call, Response<List<DisModal>> response) {
                dataList = response.body();
                // Toast.makeText(Discountmain.this, "onResponse:" + response.body().size(), Toast.LENGTH_SHORT).show();
//
//               Log.d(TAG, "onResponse: "+ dataList.size());
                LinearLayoutManager layout=new LinearLayoutManager(Allproducts.this,LinearLayoutManager.VERTICAL,false);
                discountrecycler.setLayoutManager(layout);
                disRecycAdaptor = new DisRecycAdaptor(Allproducts.this, dataList);
                discountrecycler.setAdapter(disRecycAdaptor);
                //Log.e(TAG, "onResponse:" + dataList.size());
            }

            @Override
            public void onFailure(Call<List<DisModal>> call, Throwable t) {
                Toast.makeText(Allproducts.this, "onfailure:" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: " + t.getMessage());
                retrofitFun(dataId);
            }
        });


    }

    private static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}