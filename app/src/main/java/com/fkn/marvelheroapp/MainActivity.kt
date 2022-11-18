package com.fkn.marvelheroapp

import android.os.Bundle
import android.os.StrictMode
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fkn.marvelheroapp.HeroDataList.heroMutableList
import com.fkn.marvelheroapp.retrofit.RetrofitInstance


class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        setContent {
            navController = rememberNavController()
            SetupNavGraph(navController = navController)
        }
    }
}


@Composable
internal fun home(navController: NavController) {

    heroMutableList = getDataForHeroMutableList()
    if (heroMutableList[0].name == "Error" || heroMutableList.isEmpty()) {
        ErrorMessage()
    } else {
        Column(
            Modifier
                .blur(1.dp)
                .background(color = Color(0xFF1B1919))
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.marvel),
                contentDescription = null,
                Modifier
                    .align(
                        Alignment.CenterHorizontally
                    )
            )
            Text(
                text = "Choose your hero!",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
                    .wrapContentSize(Alignment.Center)
            )

            Scroll(navController = navController)
        }
    }
}

