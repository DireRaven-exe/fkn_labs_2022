package com.fkn.marvelheroapp.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object RetrofitInstance {
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit =  Retrofit.Builder()
        .baseUrl("https://gateway.marvel.com:443")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    fun getMarvelApi(): APIService {
        return retrofit.create(APIService::class.java)
    }
}