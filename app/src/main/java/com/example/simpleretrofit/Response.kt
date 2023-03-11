package com.example.simpleretrofit

data class Response(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)