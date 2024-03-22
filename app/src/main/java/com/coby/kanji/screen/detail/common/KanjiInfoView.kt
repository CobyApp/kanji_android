package com.coby.kanji.screen.detail.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coby.kanji.entity.Character
import com.coby.kanji.entity.WordItem
import com.coby.kanji.ui.theme.JKMaru
import com.coby.kanji.ui.theme.Ownglyph

@Composable
fun KanjiInfoView(
    modifier: Modifier,
    character: Character,
    total: Int,
    count: Int
) {
    Box(
        modifier = modifier
            .background(Color.Black.copy(alpha = 0.8f), RoundedCornerShape(20.dp))
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = character.korean,
                    color = Color.White,
                    fontSize = 21.sp,
                    fontFamily = Ownglyph
                )

                Text(
                    text = "$count/$total",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = Ownglyph
                )
            }

            Spacer(modifier = Modifier.height(14.dp))
            Divider(color = Color.White, thickness = 1.dp)
            Spacer(modifier = Modifier.height(8.dp))

            if (character.fullSound.isNotEmpty()) {
                KanjiSound("음", character.fullSound)
            }

            if (character.fullMeaning.isNotEmpty()) {
                KanjiSound("훈", character.fullMeaning)
            }

            if (character.words1.isNotEmpty() || character.words2.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Divider(color = Color.White, thickness = 1.dp)
                Spacer(modifier = Modifier.height(8.dp))
            }

            character.words1.forEach { wordItem ->
                WordItem(wordItem = wordItem)
            }

            character.words2.forEach { wordItem ->
                WordItem(wordItem = wordItem)
            }
        }
    }
}

@Composable
fun KanjiSound(type: String, sound: String) {
    Row(
        modifier = Modifier.padding(vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(24.dp)
                .background(
                    color = Color.White.copy(alpha = 0.9F),
                    shape = CircleShape
                )
        ) {
            Text(
                text = type,
                fontFamily = Ownglyph,
                fontSize = 17.sp,
                color = Color.Black,
                modifier = Modifier.padding(2.dp)
            )
        }

        Text(
            text = sound,
            fontFamily = JKMaru,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}

@Composable
fun WordItem(wordItem: WordItem) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = wordItem.word,
            fontFamily = Ownglyph,
            fontSize = 17.sp,
            lineHeight = 22.sp,
            color = Color.White,
            modifier = Modifier.padding(end = 8.dp)
        )

        Text(
            text = wordItem.mean,
            fontFamily = Ownglyph,
            fontSize = 17.sp,
            lineHeight = 22.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}