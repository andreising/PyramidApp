package com.andreisingeleytsev.pyramidapp.ui.screens.levels_menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.pyramidapp.R
import com.andreisingeleytsev.pyramidapp.ui.utils.Routes

@Composable
fun LevelsMenu(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Image(
            painter = painterResource(id = R.drawable.main_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = R.drawable.levels),
                contentDescription = null,
                modifier = Modifier.width(170.dp),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(40.dp))
            Image(
                painter = painterResource(id = R.drawable.level_1),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
                    .clickable {
                        navHostController.navigate(Routes.LVL_1)
                    },
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(id = R.drawable.level_2),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
                    .clickable {
                        navHostController.navigate(Routes.LVL_2)
                    },
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(id = R.drawable.level_3),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
                    .clickable {
                        navHostController.navigate(Routes.LVL_3)
                    },
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(id = R.drawable.level_4),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
                    .clickable {
                        navHostController.navigate(Routes.LVL_4)
                    },
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(id = R.drawable.level_5),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
                    .clickable {
                        navHostController.navigate(Routes.LVL_5)
                    },
                contentScale = ContentScale.FillWidth
            )
        }
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