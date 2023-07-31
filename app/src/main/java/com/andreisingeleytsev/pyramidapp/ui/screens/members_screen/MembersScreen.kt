package com.andreisingeleytsev.pyramidapp.ui.screens.members_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.pyramidapp.R
import com.andreisingeleytsev.pyramidapp.ui.theme.MainColor
import com.andreisingeleytsev.pyramidapp.ui.utils.Routes

@Composable
fun MembersScreen(navHostController: NavHostController){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.members_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.records),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 25.dp, top = 32.dp), contentAlignment = Alignment.TopStart
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_btn),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
                .clickable {
                    navHostController.popBackStack()
                }
        )
    }
}