package com.fkn.marvelheroapp.retrofit

import com.fkn.marvelheroapp.model.Request
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("/v1/public/characters?limit=10&apikey=82cc1dda3f66ebf02d83d6241d8cd532&ts=1&hash=be8d1e0ab37ea05eb03129bbd399b11c")
    fun listHeroes(): Call<Request>

    @GET("/v1/public/characters/{id}?apikey=82cc1dda3f66ebf02d83d6241d8cd532&ts=1&hash=be8d1e0ab37ea05eb03129bbd399b11c")
    fun oneHero(@Path("id") id: Int?): Call<Request>
}





