package com.fkn.marvelheroapp

const val INFO_ARG_KEY = "name"

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object Info: Screen(route = "info_screen/{$INFO_ARG_KEY}"){
        fun passName(name:String): String{
            return this.route.replace(oldValue = "{$INFO_ARG_KEY}", newValue = name)
        }
    }
}