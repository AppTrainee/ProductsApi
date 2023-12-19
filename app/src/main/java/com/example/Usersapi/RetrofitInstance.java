package com.example.Usersapi;

import com.example.productsapi.InterfaceProd;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
 public static    RetrofitInstance instance;
 //   com.example.callingapi.apiInterface apiInterface;
   // public String api = "https://jsonplaceholder.typicode.com/";
    InterfaceProd interfaceProd;

    public RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build();
        interfaceProd=  retrofit.create(InterfaceProd.class);
    }

    public static RetrofitInstance getInstance() {
        if (instance == null) {
            instance = new RetrofitInstance();
        }
        return instance;
    }

}
