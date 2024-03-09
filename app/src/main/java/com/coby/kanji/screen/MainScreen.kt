package com.coby.kanji.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(
    onDetailButtonClick: (String) -> Unit,
) {
    Column() {
        Button(onClick = {
            onDetailButtonClick("kanji")
        }) {
            Text("한자 공부하기")
        }

        Button(onClick = {
            onDetailButtonClick("korean")
        }) {
            Text("뜻음 퀴즈")
        }

        Button(onClick = {
            onDetailButtonClick("word")
        }) {
            Text("단어 퀴즈")
        }
    }
}