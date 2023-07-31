package com.andreisingeleytsev.pyramidapp.ui.screens.game_screen

import android.os.CountDownTimer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.pyramidapp.R
import com.andreisingeleytsev.pyramidapp.ui.utils.Routes
import com.andreisingeleytsev.pyramidapp.ui.utils.UIEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class GameScreenViewModel:ViewModel() {
    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: GameScreenEvent){
        when(event) {
            is GameScreenEvent.OnHomeButtonPressed -> {
                sendUIEvent(UIEvent.OnBack)
            }
            is GameScreenEvent.OnNextLevel -> {
                when(event.difficulty) {
                    1 -> {
                        sendUIEvent(UIEvent.Navigate(Routes.LVL_2))
                    }
                    2 -> {
                        sendUIEvent(UIEvent.Navigate(Routes.LVL_3))
                    }
                    3 -> {
                        sendUIEvent(UIEvent.Navigate(Routes.LVL_4))
                    }
                    4 -> {
                        sendUIEvent(UIEvent.Navigate(Routes.LVL_5))
                    }
                    5 -> {
                        sendUIEvent(UIEvent.Navigate(Routes.MAIN_MENU_SCREEN))
                    }
                }
            }
            is GameScreenEvent.OnRestart -> {
                state.value = "game"
                timer.start()
            }
            is GameScreenEvent.OnChoose -> {
                when (event.difficulty) {

                    1 -> {
                        if (event.circle==1){
                            state.value = "win"
                            timer.cancel()
                        } else {
                            timer.cancel()
                            state.value = "loose"
                        }
                    }
                    2 -> {
                        if (event.circle==2){
                            state.value = "win"
                            timer.cancel()
                        }else {
                            timer.cancel()
                            state.value = "loose"
                        }
                    }
                    3 -> {
                        if (event.circle==4){
                            state.value = "win"
                            timer.cancel()
                        }else {
                            timer.cancel()
                            state.value = "loose"
                        }
                    }
                    4 -> {
                        if (event.circle==3){
                            state.value = "win"
                            timer.cancel()
                        }else {
                            timer.cancel()
                            state.value = "loose"
                        }
                    }
                    5 -> {
                        if (event.circle==1){
                            state.value = "win"
                            timer.cancel()
                        }else {
                            timer.cancel()
                            state.value = "loose"
                        }
                    }
                }
            }

        }
    }
    val time = mutableStateOf(5)
    val timer = object : CountDownTimer(5000, 1000) {
        override fun onTick(p0: Long) {
            time.value--
        }

        override fun onFinish() {
            state.value = "loose"
            time.value = 5
        }

    }
    private fun sendUIEvent(event: UIEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    val state = mutableStateOf("game")
    val list1 = Pair(
        R.drawable.pmd_1, listOf(
            R.drawable.lvl_1_circles_1,
            R.drawable.lvl_1_circles_2,
            R.drawable.lvl_1_circles_3,
            R.drawable.lvl_1_circles_4,
        )
    )
    val list2 = Pair(
        R.drawable.pmd_2, listOf(
            R.drawable.lvl_2_circles_1,
            R.drawable.lvl_2_circles_2,
            R.drawable.lvl_2_circles_3,
            R.drawable.lvl_2_circles_4,
        )
    )
    val list3 = Pair(
        R.drawable.pmd_3, listOf(
            R.drawable.lvl_3_circles_1,
            R.drawable.lvl_3_circles_2,
            R.drawable.lvl_3_circles_3,
            R.drawable.lvl_3_circles_4,
        )
    )
    val list4 = Pair(
        R.drawable.pmd_4, listOf(
            R.drawable.lvl_4_circles1,
            R.drawable.lvl_4_circles_2,
            R.drawable.lvl_4_circles_3,
            R.drawable.lvl_4_circles_4,
        )
    )
    val list5 = Pair(
        R.drawable.pmd_5, listOf(
            R.drawable.lvl_5_circles_1,
            R.drawable.lvl_5_circles_2,
            R.drawable.lvl_5_circles_3,
            R.drawable.lvl_5_circles_4,
        )
    )
    init {
        timer.start()
    }
}