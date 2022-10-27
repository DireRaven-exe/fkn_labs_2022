package com.fkn.marvelheroapp

import androidx.compose.ui.graphics.Color

object HeroList {
    var heroList = mapOf(
        "Deadpool" to HeroData(
            nameHero = "Deadpool",
            descriptionHero = "I'm really dead",
            linkHero = "https://img3.akspic.ru/crops/5/7/6/4/6/164675/164675-dedpul-cifrovoe_iskusstvo-supergeroj-art-artist-1080x1920.jpg",
            imageHero = R.drawable.deadpool,
            colorHero = Color(0xFFBB1818)
        ),
        "Iron Man" to HeroData(
            nameHero = "Iron Man",
            descriptionHero = "Eccentric genius, millionaire, ladies' man and philanthropist Tony Stark is also the armored superhero known as Iron Man.",
            linkHero = "https://img3.wallspic.com/previews/7/0/8/2/5/152807/152807-iron_man-doctor_strange-captain_america-spider_man-superhero-x750.jpg",
            imageHero = R.drawable.iron_man,
            colorHero = Color(0xFFE48B05)
        ),
        "Dr. Strange" to HeroData(
            nameHero = "Dr. Strange",
            descriptionHero = "The new Supreme Earth-mage, formerly a renowned neurosurgeon.",
            linkHero = "https://img1.akspic.ru/crops/0/7/1/7/6/167170/167170-doktor_strendzh-kinovselennaya_marvel-komiksy_marvel-multivselennaya-tor-1080x1920.jpg",
            imageHero = R.drawable.dr_strange,
            colorHero = Color(0xFF418804)
        ),
        "Spider Man" to HeroData(
            nameHero = "Spider Man",
            descriptionHero = "A high school student and superhero with spider-like powers who goes by the alias Spider-Man",
            linkHero = "https://img1.wallspic.com/previews/5/0/6/6/6/166605/166605-spider_man-marvels_spider_man_miles_morales-peter_parker-marvel_cinematic_universe-marvel_comics-x750.jpg",
            imageHero = R.drawable.spider_man,
            colorHero = Color(0xFF0B70CA)
        ),
        "Tanos" to HeroData(
            nameHero = "Tanos",
            descriptionHero = "A powerful space warlord who rules over a distant region of space and commanded a formidable army known as the Chitauri as well as the Outriders",
            linkHero = "https://img3.akspic.ru/crops/8/7/5/6/6/166578/166578-kinovselennaya_marvel-tanos-mstiteli-darksajd-tor-1080x1920.jpg",
            imageHero = R.drawable.tanos,
            colorHero = Color(0xFF6413B4)
        )
    )

    fun heroList(heroKey: String) : HeroData {
        return heroList.getOrDefault(heroKey, HeroData(
            nameHero = "Not Hero",
            descriptionHero = "Don't know him",
            linkHero = "https://cdn.mos.cms.futurecdn.net/39CUYMP8vJqHAYGVzUghBX.jpg",
            imageHero = 9999,
            colorHero = Color(0xFFBB1818)
            )
        )
    }
}