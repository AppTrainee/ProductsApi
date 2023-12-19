package com.example.Usersapi;

import com.example.productsapi.Mydata;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserInterface {
    @GET("users")
    Call<UsersModal> getUsers();
}
