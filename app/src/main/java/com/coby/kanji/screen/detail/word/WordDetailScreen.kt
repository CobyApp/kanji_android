package com.coby.kanji.screen.detail.word

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.coby.kanji.entity.GradeType
import com.coby.kanji.entity.ScreenState
import com.coby.kanji.entity.WordItem
import com.coby.kanji.screen.detail.common.ArrowButtons
import com.coby.kanji.screen.detail.common.DetailTopAppBarView
import com.coby.kanji.screen.detail.common.WordBoardView
import com.coby.kanji.viewmodel.CharacterViewModel

@Composable
fun WordDetailScreen(
    gradeType: GradeType,
    onDismiss: () -> Unit,
    onShowGallery: () -> Unit,
    viewModel: CharacterViewModel = hiltViewModel()
) {
    val words: List<WordItem> = viewModel.getWordsByGrade(gradeType = gradeType)
    var index by remember { mutableStateOf(0) }
    var count by remember { mutableStateOf(0) }
    var items by remember { mutableStateOf(listOf<String>("", "", "", "")) }

    LaunchedEffect(key1 = Unit) {
        index = viewModel.getIndex(screenState = ScreenState.word, gradeType = gradeType)
    }

    LaunchedEffect(index) {
        count = viewModel.getCount(screenState = ScreenState.word, word = words[index].wordKanji)
        items = viewModel.getRandomWordSounds(wordSound = words[index].wordSound)
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

            WordBoardView(word = words[index])

            WordQuizView(
                modifier = Modifier.weight(1f),
                count = count,
                index = index + 1,
                total = words.size,
                items = items,
                onSelect = {
                    if (words[index].wordSound == it) {
                        index = if (index == words.size - 1) 0 else index + 1
                        viewModel.saveIndex(
                            screenState = ScreenState.word,
                            gradeType = gradeType,
                            index = index
                        )
                    } else {
                        viewModel.saveCount(
                            screenState = ScreenState.word,
                            word = words[index].wordKanji,
                            count = ++count
                        )
                        items = viewModel.getRandomWordSounds(wordSound = words[index].wordSound)
                    }
                }
            )

            ArrowButtons(
                beforeIndex = {
                    index = if (index == 0) words.size - 1 else index - 1
                    viewModel.saveIndex(
                        screenState = ScreenState.word,
                        gradeType = gradeType,
                        index = index
                    )
                },
                nextIndex = {
                    index = if (index == words.size - 1) 0 else index + 1
                    viewModel.saveIndex(
                        screenState = ScreenState.word,
                        gradeType = gradeType,
                        index = index
                    )
                }
            )
        }
    }
}