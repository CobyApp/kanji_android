package com.coby.kanji.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coby.kanji.ui.components.SelectButton

@Composable
fun SelectView(
    modifier: Modifier = Modifier,
    onDetailButtonClick: (String) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        SelectButton(
            onClick = {
                onDetailButtonClick("kanji")
            },
            text = "한자 공부하기"
        )
    }
}