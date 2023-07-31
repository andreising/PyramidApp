package com.andreisingeleytsev.pyramidapp.ui.screens.game_screen

sealed class GameScreenEvent{
    object OnHomeButtonPressed: GameScreenEvent()
    data class OnNextLevel(val difficulty: Int): GameScreenEvent()
    object OnRestart: GameScreenEvent()
    data class OnChoose(val difficulty: Int, val circle: Int): GameScreenEvent()
}
