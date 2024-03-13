package com.coby.kanji.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coby.kanji.entity.ScreenState
import com.coby.kanji.ui.components.CommonButton

@Composable
fun StartView(
    modifier: Modifier = Modifier,
    onSelectButtonClick: (ScreenState) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CommonButton(
            onClick = {
                onSelectButtonClick(ScreenState.kanji)
            },
            text = "한자 공부하기"
        )

        CommonButton(
            onClick = {
                onSelectButtonClick(ScreenState.korean)
            },
            text = "뜻음 퀴즈"
        )

        CommonButton(
            onClick = {
                onSelectButtonClick(ScreenState.word)
            },
            text = "단어 퀴즈"
        )
    }
}