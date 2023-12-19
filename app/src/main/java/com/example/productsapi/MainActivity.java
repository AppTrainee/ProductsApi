package com.example.productsapi;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView prodRecy;
    Retrofit retrofit;
    TextView tottext, skiptext, limitText;
    List<Product> dataList;
    adaptorClass adapt;
    Mydata mydata;

    //Map data=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prodRecy = findViewById(R.id.pordrecy);
        tottext = findViewById(R.id.totText);
        skiptext = findViewById(R.id.skipText);
        limitText = findViewById(R.id.limitText);

        // retrofit=new Retrofit.Builder().baseUrl("https://dummyjson.com/").addConverterFactory(GsonConverterFactory.create()).build();
//        getprod();
        //  }

        //  private void getprod() {
        //  InterfaceProd interfaceProd = retrofit.create(InterfaceProd.class);

        RetrofitInstance.getInstance().interfaceProd.getProd().enqueue(new Callback<Mydata>() {
            @Override
            public void onResponse(Call<Mydata> call, Response<Mydata> response) {
                try {
                    mydata = response.body();
                    tottext.setText("total  :" + mydata.getTotal());
                    skiptext.setText("skip  :" + mydata.getSkip());
                    limitText.setText("limit  :" + mydata.getLimit());
                    int i=0;
                    for (Product product : dataList = mydata.getProducts()) {
                        i++;
                        Log.e(TAG, "onResponse: "+i );
                    }
//                    limitText.setText("limit  :" + dataList.size());

                    LinearLayoutManager linearLayout = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                    prodRecy.setLayoutManager(linearLayout);

                    adapt = new adaptorClass(MainActivity.this, dataList);
                    prodRecy.setAdapter(adapt);

                    //  dataList.add(mydata.getProducts().get(1));
                 //   Log.e(TAG, "onResponse: "+mydata.getProducts().size() );
                } catch (Exception e) {
                    Log.e(TAG, "Exception: " + e.getMessage());
                }
            }
            @Override
            public void onFailure(Call<Mydata> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}