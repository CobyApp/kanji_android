package com.coby.kanji.screen.detail.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coby.kanji.R
import com.coby.kanji.ui.theme.nonScaledSp

@Composable
fun BoardView(
    modifier: Modifier = Modifier,
    kanji: String
) {
    var fontSize by remember { mutableStateOf(100) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .border(width = 10.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .onGloballyPositioned { layoutCoordinates ->
                val height = layoutCoordinates.size.height
                fontSize = (height / 4)
            }
    ) {
        Text(
            text = kanji,
            color = Color.Black,
            fontSize = fontSize.nonScaledSp,
            fontFamily = FontFamily(Font(R.font.jkmaru))
        )
    }
}

@Preview
@Composable
fun PreviewKanjiBoardView() {
    BoardView(modifier = Modifier.height(300.dp).width(300.dp), kanji = "家")
}
