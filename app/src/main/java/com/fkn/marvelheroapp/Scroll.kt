package com.fkn.marvelheroapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fkn.marvelheroapp.HeroDataList.heroMutableList
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun Scroll(navController: NavController){
    val lazyListState = rememberLazyListState()
    val colorState = remember {
        mutableStateOf(Color(0xFFBB1818))
    }
    val layoutInfo: LazyListSnapperLayoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState)
    val indexLazyList = remember {
        mutableStateOf(layoutInfo.currentItem?.index)
    }
    indexLazyList.value = layoutInfo.currentItem?.index

    colorState.value = heroMutableList[getIndex(indexLazyList.value)].color

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
        for (hero in heroMutableList) {
            item(hero.name) {
                HeroImageItem(
                    color = colorState.value,
                    text = hero.name,
                    HeroPainter = hero.painter,
                    modifier = Modifier
                        .width(350.dp)
                        .fillMaxSize()
                        .aspectRatio(3 / 4f)
                        .clickable {
                            navController.navigate(route = Screen.Info.passName(hero.id)) {
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

fun getIndex(index: Int?) : Int {
    return index?.toInt() ?: 0
}