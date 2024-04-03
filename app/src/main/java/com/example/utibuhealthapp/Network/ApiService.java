package com.example.utibuhealthapp.Network;

import com.example.utibuhealthapp.Models.Order;
import com.example.utibuhealthapp.Models.Token;
import com.example.utibuhealthapp.Models.loginReq;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("auth/login")
    Call<Token> loginUser(@Body loginReq loginRequest);

    @POST("medication/order")
    Call<Order> placeOrder(@Body Order orderRequest);
}
