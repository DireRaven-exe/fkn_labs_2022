package com.fkn.marvelheroapp

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Composable
fun HeroImageItem(color: Color, text: String, HeroPainter: String?, modifier: Modifier) {
    Surface(modifier) {
        Card(
            modifier = Modifier
                .background(
                    color
                )
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    bottom = 30.dp,
                    top = 1.dp
                )
                .shadow(elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp),
                    ambientColor = Color(0xFF000000),
                    spotColor = Color(0xFF000000)
                )
                .size(320.dp, 440.dp)
                .animateContentSize(),
            shape = RoundedCornerShape(15.dp),
        ) {
            AsyncImage(
                model = HeroPainter!!.replace("http", "https"),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .size(400.dp)
                ,
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                Alignment.BottomStart
            ){
                Text(
                    text = text,
                    color = Color.White,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .shadow(150.dp)
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                        .wrapContentSize(Alignment.Center)
                )
            }
        }

    }
}
