package com.coby.kanji.screen.detail.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coby.kanji.ui.theme.Ownglyph

@Composable
fun QuizTitleView(
    modifier: Modifier = Modifier,
    count: Int,
    index: Int,
    total: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(
                color = Color.Black.copy(alpha = 0.8F),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "오답횟수 ${count}",
            style = TextStyle(
                fontFamily = Ownglyph,
                fontSize = 20.sp
            ),
            color = Color.White
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "${index}/${total}",
            style = TextStyle(
                fontFamily = Ownglyph,
                fontSize = 20.sp
            ),
            color = Color.White
        )
    }
}