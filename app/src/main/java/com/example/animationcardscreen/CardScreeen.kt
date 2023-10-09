package com.example.animationcardscreen

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun CardScreen(){

    val animation = remember{
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = true){
        animation.value = true
    }
    val animation1 = animateFloatAsState(targetValue = if(animation.value)-10f else 0f, label = "", animationSpec = InfiniteRepeatableSpec(animation = tween(2000, easing = LinearEasing), repeatMode = RepeatMode.Reverse))
    val animation2 = animateFloatAsState(targetValue = if(animation.value)-8f else 0f, label = "", animationSpec = InfiniteRepeatableSpec(animation = tween(2000, easing = LinearEasing), repeatMode = RepeatMode.Reverse))

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier
            .size(350.dp)
            .graphicsLayer {
                rotationX = 10f
                rotationY = 10f
                rotationZ = 10f
            }, contentAlignment = Alignment.Center){
           Card(modifier = Modifier
               .height(200.dp)
               .width(300.dp)
               .graphicsLayer {
                   rotationY = animation1.value
                   rotationZ = animation2.value
               }
               , colors = CardDefaults.cardColors(Color.Gray)) {


           }

            Card(modifier = Modifier
                .height(200.dp)
                .width(300.dp)
                .graphicsLayer {
                    rotationY = animation1.value
                    rotationZ = animation2.value
                }
                .offset(y = (-30).dp, x = (20).dp)

            , colors = CardDefaults.cardColors(Color.Red)) {
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("suraj",color = Color.White, fontSize = 50.sp)
                }

            }
        }
    }
}