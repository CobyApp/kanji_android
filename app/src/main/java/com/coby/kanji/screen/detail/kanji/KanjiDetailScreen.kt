package com.coby.kanji.screen.detail.kanji

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
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
import com.coby.kanji.ui.components.board.KanjiBoardView
import com.coby.kanji.ui.components.button.CloseButton
import com.coby.kanji.ui.components.button.CommonButton
import com.coby.kanji.viewmodel.CharacterViewModel

@Composable
fun KanjiDetailScreen(
    gradeType: GradeType,
    onDismiss: () -> Unit,
    onShowGallery: () -> Unit,
    viewModel: CharacterViewModel = hiltViewModel()
) {
    val kanjis: List<Character> = viewModel.getCharactersByGrade(gradeType = gradeType)
    var index by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        index = viewModel.getIndex(screenState = ScreenState.kanji, gradeType = gradeType)
    }

    DisposableEffect(key1 = Unit) {
        onDispose {
            viewModel.saveIndex(screenState = ScreenState.kanji, gradeType = gradeType, index = index)
        }
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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TopAppBarView(onDismiss = onDismiss, onShowGallery = onShowGallery)

            KanjiBoardView(kanji = kanjis[index].kanji)

            KanjiInfoView(character = kanjis[index], total = kanjis.size, count = index + 1)
        }
    }
}

@Composable
fun TopAppBarView(onDismiss: () -> Unit, onShowGallery: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        CloseButton(
            modifier = Modifier,
            onClick = onDismiss
        )

        Spacer(modifier = Modifier.weight(1f))

        CommonButton(
            modifier = Modifier
                .width(80.dp)
                .height(50.dp),
            text = "목록",
            onClick = onShowGallery
        )
    }
}