package com.example.productsapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceProd {
    @GET("products")
    Call<Mydata> getProd();
}
