package com.coby.kanji.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coby.kanji.R
import com.coby.kanji.entity.ScreenState
import com.coby.kanji.ui.components.CommonButton

@Composable
fun MainScreen(
    onStartButtonClick: (ScreenState) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.mainbg), // 배경 이미지 리소스
            contentDescription = null, // 접근성을 위한 설명 (배경 이미지이므로 null로 설정)
            modifier = Modifier.fillMaxSize(), // Box 컨테이너 전체 크기로 이미지를 설정
            contentScale = ContentScale.Crop // 이미지가 Box의 크기에 맞춰 잘리거나 늘어나도록 설정
        )

        Column(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CommonButton(
                onClick = {
                    onStartButtonClick(ScreenState.kanji)
                },
                text = "한자 공부하기"
            )

            CommonButton(
                onClick = {
                    onStartButtonClick(ScreenState.korean)
                },
                text = "뜻음 퀴즈"
            )

            CommonButton(
                onClick = {
                    onStartButtonClick(ScreenState.word)
                },
                text = "단어 퀴즈"
            )
        }
    }
}