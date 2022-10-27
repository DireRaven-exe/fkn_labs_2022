package com.fkn.marvelheroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.fkn.marvelheroapp.HeroList.heroList
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            SetupNavGraph(navController = navController)
        }
    }
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
internal fun home(navController: NavController) {
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

        val lazyListState = rememberLazyListState()
        val colorState = remember {
            mutableStateOf(Color(0xFFBB1818))
        }
        val layoutInfo: LazyListSnapperLayoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState)
        val indexLazyList = remember {
            mutableStateOf(layoutInfo.currentItem?.index)
        }
        indexLazyList.value = layoutInfo.currentItem?.index

        when (indexLazyList.value) {
            0 -> colorState.value = heroList("Deadpool").color
            1 -> colorState.value = heroList("Iron Man").color
            2 -> colorState.value = heroList("Dr. Strange").color
            3 -> colorState.value = heroList("Spider Man").color
            4 -> colorState.value = heroList("Tanos").color
        }

        LazyRow(
            state = lazyListState,
            flingBehavior = rememberSnapperFlingBehavior(lazyListState),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorState.value),
            contentPadding = PaddingValues(35.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(50.dp)
        )
        {
            for (hero in heroList) {
                item(hero.key) {
                    HeroImageItem(
                        color = colorState.value,
                        text = hero.key,
                        HeroPainter = painterResource(id = hero.value.image),
                        modifier = Modifier
                            .width(350.dp)
                            .fillMaxSize()
                            .aspectRatio(3 / 4f)
                            .clickable {
                                navController.navigate(route = Screen.Info.passName(hero.key)) {
                                    navController.graph.startDestinationRoute?.let { route ->
                                        popUpTo(route) {
                                            saveState = true
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
    }
}

