package com.fkn.marvelheroapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fkn.marvelheroapp.retrofit.RetrofitInstance


@Composable
fun HeroInfo(navController: NavController, idHero: Int?) {
    val api = RetrofitInstance.getMarvelApi()
    val call = api.oneHero(idHero).execute().body()?.data?.results?.get(0)
    Surface {
        Box {
            AsyncImage(
                model =  call?.thumbnail?.path?.replace("http", "https") + "/portrait_incredible."+call?.thumbnail?.extension,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .blur(10.dp),
                contentScale = ContentScale.Crop
            )

        }
        Box(
            modifier = Modifier.fillMaxSize(),
            Alignment.BottomStart
        ) {
            Column {
                Text(
                    text = call?.name!!,
                    color = Color.White,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentSize(Alignment.Center)
                        .blur(1.dp),
                    style = TextStyle(
                        fontSize = 42.sp,
                        shadow = Shadow(
                            color = Color.Blue
                        )
                    )
                )
                Text(
                    text = call.description!!,
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentSize(Alignment.Center)
                        .blur(1.dp)
                )
            }
        }
        Box {
            Image(
                painter = painterResource(R.drawable.icon_left),
                contentDescription = null,
                modifier = Modifier
                    .padding(
                        start = 5.dp,
                        bottom = 30.dp,
                        top = 15.dp
                    )
                    .size(40.dp)
                    .align(Alignment.TopStart)
                    .clickable {
                        navController.navigate(route = Screen.Home.route){
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = false
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
            )
        }
    }
}


