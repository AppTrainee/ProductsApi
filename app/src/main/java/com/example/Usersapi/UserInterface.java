package com.example.Usersapi;

import com.example.productsapi.Mydata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserInterface {
    @GET("users")
    Call<UsersModal> getUsers();

//    @GET("users")
//    Call<UsersModal> getUsers(@Query("product_id") int productId);
}
