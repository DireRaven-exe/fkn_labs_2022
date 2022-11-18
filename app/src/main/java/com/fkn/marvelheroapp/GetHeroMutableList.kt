package com.fkn.marvelheroapp

import androidx.compose.ui.graphics.Color
import com.fkn.marvelheroapp.model.Results
import com.fkn.marvelheroapp.retrofit.RetrofitInstance
import java.net.UnknownHostException

fun getDataForHeroMutableList() : MutableList<HeroData> {
    val api = RetrofitInstance.getMarvelApi()
    val list : List<Results>
    val mutableList : MutableList<HeroData> = mutableListOf()
    try {
        list = api.listHeroes().execute().body()?.data?.results!!
        for (it in list) {
            mutableList.add(
                HeroData(
                    idHero = it.id!!,
                    nameHero = it.name!!,
                    painterHero = it.thumbnail?.path + "/portrait_incredible.jpg",
                    colorHero = HeroDataList.heroColorList.random()
                )
            )
        }
    } catch (e: UnknownHostException) {
        mutableList.add(HeroData(
            idHero = "none",
            nameHero = "Error",
            painterHero = "none",
            colorHero = Color.Gray
            ))
    }
    return mutableList
}