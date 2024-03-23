package com.coby.kanji.screen.detail.korean

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.coby.kanji.R
import com.coby.kanji.entity.Character
import com.coby.kanji.entity.GradeType
import com.coby.kanji.entity.ScreenState
import com.coby.kanji.screen.detail.common.ArrowButtons
import com.coby.kanji.screen.detail.common.DetailTopAppBarView
import com.coby.kanji.screen.detail.common.BoardView
import com.coby.kanji.viewmodel.CharacterViewModel

@Composable
fun KoreanDetailScreen(
    gradeType: GradeType,
    onDismiss: () -> Unit,
    onShowGallery: () -> Unit,
    viewModel: CharacterViewModel = hiltViewModel()
) {
    val kanjis: List<Character> = viewModel.getCharactersByGrade(gradeType = gradeType)
    var index by remember { mutableStateOf(0) }
    var count by remember { mutableStateOf(0) }
    var items by remember { mutableStateOf(listOf<String>("", "", "", "")) }

    LaunchedEffect(key1 = Unit) {
        index = viewModel.getIndex(screenState = ScreenState.korean, gradeType = gradeType)
    }

    LaunchedEffect(index) {
        count = viewModel.getCount(screenState = ScreenState.korean, word = kanjis[index].kanji)
        items = viewModel.getRandomKoreans(korean = kanjis[index].korean)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.detailbg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DetailTopAppBarView(onDismiss = onDismiss, onShowGallery = onShowGallery)

            BoardView(
                modifier = Modifier
                    .padding(horizontal = 40.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.0f),
                kanji = kanjis[index].kanji
            )

            KoreanQuizView(
                modifier = Modifier.weight(1f),
                count = count,
                index = index + 1,
                total = kanjis.size,
                items = items,
                onSelect = {
                    if (kanjis[index].korean == it) {
                        index = if (index == kanjis.size - 1) 0 else index + 1
                        viewModel.saveIndex(
                            screenState = ScreenState.korean,
                            gradeType = gradeType,
                            index = index
                        )
                    } else {
                        viewModel.saveCount(
                            screenState = ScreenState.korean,
                            word = kanjis[index].kanji,
                            count = ++count
                        )
                        items = viewModel.getRandomKoreans(korean = kanjis[index].korean)
                    }
                }
            )

            ArrowButtons(
                beforeIndex = {
                    index = if (index == 0) kanjis.size - 1 else index - 1
                    viewModel.saveIndex(
                        screenState = ScreenState.korean,
                        gradeType = gradeType,
                        index = index
                    )
                },
                nextIndex = {
                    index = if (index == kanjis.size - 1) 0 else index + 1
                    viewModel.saveIndex(
                        screenState = ScreenState.korean,
                        gradeType = gradeType,
                        index = index
                    )
                }
            )
        }
    }
}