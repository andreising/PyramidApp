package com.andreisingeleytsev.pyramidapp.ui.utils

sealed class UIEvent{
    data class Navigate(val route: String): UIEvent()
    object OnBack: UIEvent()
}
