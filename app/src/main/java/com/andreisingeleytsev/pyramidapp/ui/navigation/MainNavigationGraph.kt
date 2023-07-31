package com.andreisingeleytsev.pyramidapp.ui.navigation


import android.media.MediaPlayer
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.pyramidapp.ui.screens.game_screen.GameScreen
import com.andreisingeleytsev.pyramidapp.ui.screens.levels_menu.LevelsMenu
import com.andreisingeleytsev.pyramidapp.ui.screens.main_menu.MainMenu
import com.andreisingeleytsev.pyramidapp.ui.screens.members_screen.MembersScreen
import com.andreisingeleytsev.pyramidapp.ui.screens.rules.RulesScreen
import com.andreisingeleytsev.pyramidapp.ui.screens.settings_screen.SettingsScreen
import com.andreisingeleytsev.pyramidapp.ui.utils.Routes


@Composable
fun MainNavigationGraph(mediaPlayer: MediaPlayer?) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MAIN_MENU_SCREEN) {
        composable(Routes.MAIN_MENU_SCREEN) {
            MainMenu(navController)
        }
        composable(Routes.LVL_1) {
            GameScreen(navController,1)
        }
        composable(Routes.LVL_2) {
            GameScreen(navController, 3)
        }
        composable(Routes.LVL_3) {
            GameScreen(navController, 3)
        }
        composable(Routes.LVL_4) {
            GameScreen(navController, 4)
        }
        composable(Routes.LVL_5) {
            GameScreen(navController, 5)
        }

        composable(Routes.LEVELS_SCREEN) {
            LevelsMenu(navController)
        }
        composable(Routes.MEMBERS_SCREEN) {
            MembersScreen(navController)
        }
        composable(Routes.SETTINGS_SCREEN) {
            SettingsScreen(navController, mediaPlayer)
        }
        composable(Routes.RULES_SCREEN) {
            RulesScreen()
        }
    }
}