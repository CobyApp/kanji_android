package com.coby.kanji.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coby.kanji.R

@Composable
fun BoardView(
    modifier: Modifier = Modifier,
    kanji: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .border(width = 10.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .padding(20.dp)
            .width(150.dp)
            .height(150.dp)
    ) {
        Text(
            text = kanji,
            color = Color.Black,
            fontSize = 120.sp,
            fontFamily = FontFamily(Font(R.font.jkmaru))
        )
    }
}

@Preview
@Composable
fun PreviewKanjiBoardView() {
    BoardView(modifier = Modifier, kanji = "家")
}