package com.coby.kanji.screen.detail.korean

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import com.coby.kanji.screen.detail.kanji.KanjiBoardView
import com.coby.kanji.screen.detail.kanji.KanjiInfoView
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

    LaunchedEffect(key1 = Unit) {
        index = viewModel.getIndex(screenState = ScreenState.korean, gradeType = gradeType)
    }

    LaunchedEffect(index) {
        count = viewModel.getCount(screenState = ScreenState.korean, word = kanjis[index].kanji)
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

            KanjiBigBoardView(kanji = kanjis[index].kanji)

            Spacer(modifier = Modifier.height(16.dp))

            KoreanQuizView(
                modifier = Modifier.weight(1f),
                count = count,
                index = index + 1,
                total = kanjis.size,
                items = viewModel.getRandomKoreans(korean = kanjis[index].korean),
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