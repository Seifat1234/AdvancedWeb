package com.example.pharmacy.Service;

import com.example.pharmacy.model.Customer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CustomerAPI {
    @POST("/api/customer")
    Call<Customer> save(@Body Customer customer);

}
