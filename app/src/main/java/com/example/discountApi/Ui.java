package com.example.discountApi;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

public class Ui extends AppCompatActivity {
    Context context;
    TextView red1;
    TextView prodDescp;
    String url = "https://www.afsupply.com//media//catalog//product//M//O//MOE14718_1.jpg";
    String prodId;
   String pos;
    ImageView cardimg1;
    List<DisModal> Singledata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        cardimg1 = findViewById(R.id.cardimg1);
        red1 = findViewById(R.id.red1);
        prodDescp = findViewById(R.id.descp);

        /*getting productId*/
//        Intent info = getIntent();
//        prodId = info.getStringExtra("prodid");


//        Glide.with(this)
//                .load(url)
//                .into(cardimg1);
        retrofitFun("8390");

    }

    private void retrofitFun(String dataId) {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://phplaravel-882494-3459554.cloudwaysapps.com/").addConverterFactory(GsonConverterFactory.create()).client(getUnsafeOkHttpClient()).build();
//        discountInterface = retrofit.create(DiscountInterface.class);
        RetrofitInstance.getInstance().discountInterface.getData(Integer.parseInt(dataId)).enqueue(new Callback<List<DisModal>>() {
            @Override
            public void onResponse(Call<List<DisModal>> call, Response<List<DisModal>> response) {
                Singledata = response.body();
//                prodDescp.setText(Singledata.get(1).getProduct_id().toString());

                Intent info = getIntent();
                pos = info.getStringExtra("position");
                //Log.e(TAG, "onResponseposition: "+pos );

//              prodDescp.setText(Singledata.get(Integer.parseInt(pos)).getProduct_id().toString());

//              Log.d(TAG, "onResponseSize: "+ Singledata.size());
//                LinearLayoutManager layout=new LinearLayoutManager(Allproducts.this,LinearLayoutManager.VERTICAL,false);
//                discountrecycler.setLayoutManager(layout);
//                disRecycAdaptor = new DisRecycAdaptor(Allproducts.this, dataList);
//                discountrecycler.setAdapter(disRecycAdaptor);
//                //Log.e(TAG, "onResponse:" + dataList.size());
            }

            @Override
            public void onFailure(Call<List<DisModal>> call, Throwable t) {
//                Toast.makeText(Allproducts.this, "onfailure:" + t.getMessage(), Toast.LENGTH_SHORT).show();
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