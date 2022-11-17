package com.fkn.marvelheroapp

import androidx.compose.ui.graphics.Color

object HeroDataList {
    var heroColorList = listOf(
        Color(0xFFBB1818),
        Color(0xFFE48B05),
        Color(0xFF418804),
        Color(0xFF0B70CA),
        Color(0xFF6413B4),
        Color(0xFFFF5722),
    )

    var heroMutableList : MutableList<HeroData> = mutableListOf()
}