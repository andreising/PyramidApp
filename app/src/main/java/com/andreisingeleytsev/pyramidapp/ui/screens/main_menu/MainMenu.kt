package com.andreisingeleytsev.pyramidapp.ui.screens.main_menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
fun MainMenu(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.main_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column() {
            Image(
                painter = painterResource(id = R.drawable.settings_button),
                contentDescription = null,
                modifier = Modifier
                    .width(210.dp)
                    .clickable {
                        navHostController.navigate(Routes.SETTINGS_SCREEN)
                    },
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(id = R.drawable.lvls_btn),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 40.dp)
                    .width(210.dp)
                    .clickable {
                        navHostController.navigate(Routes.LEVELS_SCREEN)
                    },
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(id = R.drawable.rules_btn),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 80.dp)
                    .width(210.dp)
                    .clickable {
                        navHostController.navigate(Routes.RULES_SCREEN)
                    },
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(id = R.drawable.start_button),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 120.dp)
                    .width(210.dp)
                    .clickable {
                        navHostController.navigate(Routes.LVL_1)
                    },
                contentScale = ContentScale.FillWidth
            )
            Image(
                painter = painterResource(id = R.drawable.members_btn),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 80.dp)
                    .width(210.dp)
                    .clickable {
                        navHostController.navigate(Routes.MEMBERS_SCREEN)
                    },
                contentScale = ContentScale.FillWidth
            )

        }
    }
}