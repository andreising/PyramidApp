package com.andreisingeleytsev.pyramidapp.ui.screens.game_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.pyramidapp.R
import com.andreisingeleytsev.pyramidapp.ui.theme.MainColor
import com.andreisingeleytsev.pyramidapp.ui.utils.Routes
import com.andreisingeleytsev.pyramidapp.ui.utils.UIEvent

@Composable
fun GameScreen(navHostController: NavHostController, difficulty: Int, viewModel: GameScreenViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect {
            when (it) {
                is UIEvent.Navigate -> {
                    navHostController.navigate(it.route)
                }
                is UIEvent.OnBack -> {
                    navHostController.popBackStack()
                }
            }
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MainColor), contentAlignment = Alignment.Center) {
        when (viewModel.state.value) {
            "game" -> Column(
                Modifier
                    .padding(top = 50.dp)
                    .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.level_card),
                        contentDescription = null,
                        modifier = Modifier.width(170.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = "LEVEL $difficulty", style = TextStyle(
                            color = Color.White, fontSize = 28.sp
                        )
                    )
                }
                Text(
                    text = viewModel.time.value.toString(), style = TextStyle(
                        color = Color.Green, fontSize = 40.sp
                    )
                )
                val pair = when(difficulty) {
                    1 -> {
                        viewModel.list1
                    }
                    2 -> {
                        viewModel.list2
                    }
                    3 -> {
                        viewModel.list3
                    }
                    4 -> {
                        viewModel.list4
                    }
                    5 -> {
                        viewModel.list5
                    }
                    else -> {
                        viewModel.list1
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        painter = painterResource(id = pair.first),
                        contentDescription = null,
                        modifier = Modifier.width(180.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(Color.White)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "1",
                            style = TextStyle(
                                fontSize = 32.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Image(
                            painter = painterResource(id = pair.second[0]),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    viewModel.onEvent(GameScreenEvent.OnChoose(difficulty, 1))
                                }
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Image(
                            painter = painterResource(id = pair.second[2]),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    viewModel.onEvent(GameScreenEvent.OnChoose(difficulty, 3))
                                }
                        )
                        Text(text = "3",
                            style = TextStyle(
                                fontSize = 32.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            ))
                    }
                    Spacer(modifier = Modifier.width(24.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "2",
                            style = TextStyle(
                                fontSize = 32.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            ))
                        Image(
                            painter = painterResource(id = pair.second[1]),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    viewModel.onEvent(GameScreenEvent.OnChoose(difficulty, 2))
                                }
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Image(
                            painter = painterResource(id = pair.second[3]),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    viewModel.onEvent(GameScreenEvent.OnChoose(difficulty, 4))
                                }
                        )
                        Text(text = "4",
                            style = TextStyle(
                                fontSize = 32.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            ))
                    }
                }
            }
            "win" -> Win(difficulty)
            "loose" -> Loose()
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
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    viewModel.onEvent(GameScreenEvent.OnHomeButtonPressed)
                }
        )
    }
}

@Composable
fun Win(difficulty: Int, viewModel: GameScreenViewModel = hiltViewModel()) {
    Image(
        painter = painterResource(id = R.drawable.next_lvl),
        contentDescription = null,
        Modifier
            .width(300.dp)
            .clickable {
                viewModel.onEvent(GameScreenEvent.OnNextLevel(difficulty))
            },
        contentScale = ContentScale.FillWidth
    )
}
@Composable
fun Loose(viewModel: GameScreenViewModel = hiltViewModel()) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "YOU LOOSE", style = TextStyle(
                color = Color.White, fontSize = 40.sp
            )
        )
        Spacer(modifier = Modifier.height(80.dp))
        Image(
            painter = painterResource(id = R.drawable.home_btn),
            contentDescription = null,
            Modifier.width(220.dp)
                .clickable {
                    viewModel.onEvent(GameScreenEvent.OnHomeButtonPressed)
                },
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(40.dp))
        Image(
            painter = painterResource(id = R.drawable.restart),
            contentDescription = null,
            Modifier.width(220.dp)
                .clickable {
                    viewModel.onEvent(GameScreenEvent.OnRestart)
                },
            contentScale = ContentScale.FillWidth
        )
    }

}