package com.andreisingeleytsev.pyramidapp.ui.screens.rules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andreisingeleytsev.pyramidapp.ui.theme.MainColor

@Composable
fun RulesScreen() {
    Box(modifier = Modifier.fillMaxSize().background(MainColor), contentAlignment = Alignment.Center) {
        Text(text ="A game in which you have to guess the right pyramid from the side view", style = TextStyle(
            color = Color.White, fontSize = 30.sp
        ), modifier = Modifier.padding(20.dp))
    }
}