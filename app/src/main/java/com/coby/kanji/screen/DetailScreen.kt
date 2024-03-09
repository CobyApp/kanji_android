package com.coby.kanji.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen(
    state: String,
    onBackButtonClick: () -> Unit,
) {
    Column() {
        Button(onClick = {
            onBackButtonClick()
        }) {
            Text("뒤로가기")
        }
    }
}