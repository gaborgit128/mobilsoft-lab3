package com.example.mobsoft.mobsoft_lab3.network.advert;


import com.example.mobsoft.mobsoft_lab3.interactor.login.model.LoginResult;
import com.example.mobsoft.mobsoft_lab3.model.Credential;
import com.example.mobsoft.mobsoft_lab3.model.User;

import java.math.BigDecimal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserApi {

    @POST("Users/login")
    Call<LoginResult> userLogin(@Body Credential credentials);


    @POST("Users/logout")
    Call<Void> userLogout(@Query("accessToken") String accessToken);


    @GET("Users/{id}")
    Call<User> userFindById(@Path("id") BigDecimal id);
}

