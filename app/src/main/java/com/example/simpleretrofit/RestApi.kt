package com.example.simpleretrofit

import retrofit2.Call
import retrofit2.http.GET

interface RestApi {
    @GET("/products")
    fun getProduct():Call<Response>
}