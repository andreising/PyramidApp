package com.andreisingeleytsev.pyramidapp.ui.screens.settings_screen

import android.content.Context
import android.media.MediaPlayer
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
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
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.andreisingeleytsev.pyramidapp.R
import com.andreisingeleytsev.pyramidapp.ui.theme.MainColor
import com.andreisingeleytsev.pyramidapp.ui.utils.Routes

@Composable
fun SettingsScreen(navController: NavController, mediaPlayer: MediaPlayer?) {
    val sound = remember {
        mutableStateOf(true)
    }
    val vibration = remember {
        mutableStateOf(false)
    }
    val vibrator = LocalContext.current.applicationContext.getSystemService(
        Context.VIBRATOR_SERVICE) as Vibrator
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Image(
            painter = painterResource(id = R.drawable.main_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.sound),
                contentDescription = null,
                modifier = Modifier.size(90.dp)
            )
            Text(
                text = "sound", style = TextStyle(
                    color = Color.White, fontSize = 40.sp
                )
            )
            Switch(
                checked = sound.value, onCheckedChange = {
                    sound.value = !sound.value
                    if (sound.value) {
                        mediaPlayer?.start()
                    } else mediaPlayer?.stop()
                }, colors = SwitchDefaults.colors(
                    uncheckedTrackColor = Color.White,
                    checkedTrackColor = Color.Black,
                    uncheckedThumbColor = MainColor,
                    checkedThumbColor = MainColor
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.vibration),
                contentDescription = null,
                modifier = Modifier.size(90.dp)
            )
            Text(
                text = "vibration", style = TextStyle(
                    color = Color.White, fontSize = 40.sp
                )
            )
            Switch(
                checked = vibration.value, onCheckedChange = {
                    vibration.value = !vibration.value
                    if (vibration.value) {
                        val canVibrate: Boolean = vibrator.hasVibrator()
                        val milliseconds = 1000L
                        if (canVibrate) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                // API 26
                                vibrator.vibrate(
                                    VibrationEffect.createOneShot(
                                        milliseconds,
                                        VibrationEffect.DEFAULT_AMPLITUDE
                                    )
                                )
                            } else {
                                // This method was deprecated in API level 26
                                vibrator.vibrate(milliseconds)
                            }
                        }
                    }
                }, colors = SwitchDefaults.colors(
                    uncheckedTrackColor = Color.White,
                    checkedTrackColor = Color.Black,
                    uncheckedThumbColor = MainColor,
                    checkedThumbColor = MainColor
                )
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
                    navController.popBackStack()
                }
        )
    }
}