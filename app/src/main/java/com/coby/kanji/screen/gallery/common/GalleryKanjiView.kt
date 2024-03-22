package com.coby.kanji.screen.gallery.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import com.coby.kanji.screen.detail.common.KanjiBoardView

@Composable
fun GalleryKanjiView(
    modifier: Modifier = Modifier,
    kanji: String,
    isChecked: Boolean
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(color = Color.White.copy(alpha = 0.8f), shape = RoundedCornerShape(20.dp))
    ) {
        Text(
            text = kanji,
            color = Color.Black,
            fontSize = 50.sp,
            fontFamily = FontFamily(Font(R.font.jkmaru))
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

@Preview
@Composable
fun PreviewGalleryKanjiView() {
    GalleryKanjiView(modifier = Modifier, kanji = "家", isChecked = true)
}