package com.example.simpleretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.JsonObject
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit=Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val restApi:RestApi=retrofit.create(RestApi::class.java)

        restApi.getProduct().enqueue(object : Callback<Response?> {
            override fun onResponse(
                call: Call<Response?>,
                response: retrofit2.Response<Response?>
            ) {
               Log.d("myproduct",response.body().toString())
            }

            override fun onFailure(call: Call<Response?>, t: Throwable) {
               Log.d("myproduct",t.message.toString())
            }
        })
    }
}