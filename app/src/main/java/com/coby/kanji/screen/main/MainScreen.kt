package com.coby.kanji.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coby.kanji.R
import com.coby.kanji.entity.ScreenState

@Composable
fun MainScreen(
    onDetailButtonClick: (String) -> Unit,
) {
    var screenState by remember { mutableStateOf(ScreenState.start) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.mainbg), // 배경 이미지 리소스
            contentDescription = null, // 접근성을 위한 설명 (배경 이미지이므로 null로 설정)
            modifier = Modifier.fillMaxSize(), // Box 컨테이너 전체 크기로 이미지를 설정
            contentScale = ContentScale.Crop // 이미지가 Box의 크기에 맞춰 잘리거나 늘어나도록 설정
        )

        when (screenState) {
            ScreenState.start -> {
                StartView(
                    modifier = Modifier
                        .padding(24.dp)
                        .align(Alignment.BottomCenter),
                    onSelectButtonClick = {
                        val newState = it
                        screenState = newState
                    }
                )
            }
            ScreenState.kanji -> {
                SelectView(
                    modifier = Modifier
                        .padding(24.dp)
                        .align(Alignment.TopCenter),
                    onDetailButtonClick = {
                        val newState = it
                        onDetailButtonClick(newState)
                    }
                )
            }
            ScreenState.korean -> {
                // KoreanView 또는 한국어 화면에 해당하는 컴포저블
            }
            ScreenState.word -> {
                // WordView 또는 단어 화면에 해당하는 컴포저블
            }
        }
    }
}