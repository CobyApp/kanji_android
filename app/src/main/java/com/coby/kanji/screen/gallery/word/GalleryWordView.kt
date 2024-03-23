package com.coby.kanji.screen.gallery.word

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coby.kanji.R

@Composable
fun GalleryWordView(
    modifier: Modifier = Modifier,
    kanji: String,
    isChecked: Boolean
) {
    var fontSize by remember { mutableStateOf(100.sp) }
    var lineHeight by remember { mutableStateOf(100.sp) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(color = Color.White.copy(alpha = 0.8f), shape = RoundedCornerShape(20.dp))
            .onGloballyPositioned { layoutCoordinates ->
                val width = layoutCoordinates.size.width
                fontSize = (width / 10).sp
                lineHeight = (width / 9).sp
            }
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = kanji,
            color = Color.Black,
            fontSize = fontSize,
            fontFamily = FontFamily(Font(R.font.jkmaru)),
            lineHeight = lineHeight,
            textAlign = TextAlign.Center
        )

        if (isChecked) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f))
            )
        }
    }
}