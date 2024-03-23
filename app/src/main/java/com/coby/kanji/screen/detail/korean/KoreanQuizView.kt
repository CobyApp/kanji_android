package com.coby.kanji.screen.detail.korean

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coby.kanji.screen.detail.common.QuizTitleView
import com.coby.kanji.ui.theme.Ownglyph

@Composable
fun KoreanQuizView(
    modifier: Modifier = Modifier,
    count: Int,
    index: Int,
    total: Int,
    items: List<String>,
    onSelect: (String) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        QuizTitleView(count = count, index = index, total = total)

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            KoreanQuizItemView(
                modifier = Modifier.weight(1f),
                item = items[0],
                onSelect = onSelect
            )

            KoreanQuizItemView(
                modifier = Modifier.weight(1f),
                item = items[1],
                onSelect = onSelect
            )
        }

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            KoreanQuizItemView(
                modifier = Modifier.weight(1f),
                item = items[2],
                onSelect = onSelect
            )

            KoreanQuizItemView(
                modifier = Modifier.weight(1f),
                item = items[3],
                onSelect = onSelect
            )
        }
    }
}

@Composable
fun KoreanQuizItemView(
    modifier: Modifier = Modifier,
    item: String,
    onSelect: (String) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .clickable { onSelect(item) }
            .background(
                color = Color.Black.copy(alpha = 0.8F),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center,
            text = item,
            style = TextStyle(
                fontFamily = Ownglyph,
                fontSize = 20.sp
            ),
            color = Color.White
        )
    }
}