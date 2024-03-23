package com.coby.kanji.screen.detail.word

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coby.kanji.screen.detail.common.QuizTitleView
import com.coby.kanji.ui.theme.JKMaru
import com.coby.kanji.ui.theme.Ownglyph

@Composable
fun WordQuizView(
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

        LazyVerticalGrid(
            modifier = Modifier.weight(1f),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(0.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            this.items(items) { item ->
                WordQuizItemView(
                    item = item,
                    onSelect = onSelect
                )
            }
        }
    }
}

@Composable
fun WordQuizItemView(
    item: String,
    onSelect: (String) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .clickable { onSelect(item) }
            .background(
                color = Color.Black.copy(alpha = 0.8F),
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        Text(
            text = item,
            style = TextStyle(
                fontFamily = JKMaru,
                fontSize = 20.sp
            ),
            color = Color.White
        )
    }
}