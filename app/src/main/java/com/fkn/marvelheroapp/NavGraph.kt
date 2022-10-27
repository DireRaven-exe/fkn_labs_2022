package com.fkn.marvelheroapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph( navController: NavHostController) {
   NavHost(
       navController = navController,
       startDestination = Screen.Home.route
   ){
       composable(route = Screen.Home.route) {
           home(navController = navController)
       }
       composable(route = Screen.Info.route, arguments = listOf(navArgument("name"){
           type = NavType.StringType
       })) {
           HeroInfoActivity(navController = navController, it.arguments?.getString("name").toString())
       }
   }
}