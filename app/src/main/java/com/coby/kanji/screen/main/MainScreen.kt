package com.coby.kanji.screen.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coby.kanji.R
import com.coby.kanji.entity.ScreenState
import com.coby.kanji.ui.components.button.CommonButton

@Composable
fun MainScreen(
    onStartButtonClick: (ScreenState) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.mainbg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            CommonButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                text = "한자 공부하기",
                onClick = {
                    onStartButtonClick(ScreenState.kanji)
                }
            )

            CommonButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                text = "뜻음 퀴즈",
                onClick = {
                    onStartButtonClick(ScreenState.korean)
                }
            )

            CommonButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                text = "단어 퀴즈",
                onClick = {
                    onStartButtonClick(ScreenState.word)
                }
            )
        }
    }
}