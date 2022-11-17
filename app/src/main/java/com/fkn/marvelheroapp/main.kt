package com.fkn.marvelheroapp

import com.fkn.marvelheroapp.model.Request
import com.fkn.marvelheroapp.retrofit.RetrofitInstance
import retrofit2.Call

fun main() {
    var api = RetrofitInstance.getMarvelApi()
    var call: Call<Request> = api.oneHero(1009268)


    var list = call.execute().body()
    println("LIST ITEM: "+list!!.toString())
    var list2 = api.listHeroes().execute().body()?.data?.results
    println("LIST2 ITEM: "+list2!!.size)
}