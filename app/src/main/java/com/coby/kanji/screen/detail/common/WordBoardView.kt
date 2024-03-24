package com.coby.kanji.screen.detail.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coby.kanji.R
import com.coby.kanji.entity.WordItem
import com.coby.kanji.ui.theme.nonScaledSp

@Composable
fun WordBoardView(
    modifier: Modifier = Modifier,
    word: WordItem
) {
    var fontSize by remember { mutableStateOf(50) }

    Column(
        modifier = modifier
            .border(width = 10.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .onGloballyPositioned { layoutCoordinates ->
                val height = layoutCoordinates.size.height
                fontSize = (height / 15)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = word.wordKanji,
            color = Color.Black,
            fontSize = fontSize.nonScaledSp,
            fontFamily = FontFamily(Font(R.font.jkmaru))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            modifier = Modifier.padding(horizontal = 10.dp),
            text = word.mean,
            color = Color.Black,
            fontSize = (fontSize * 0.5).toInt().nonScaledSp,
            fontFamily = FontFamily(Font(R.font.ownglyph))
        )
    }
}