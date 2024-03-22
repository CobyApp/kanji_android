package com.coby.kanji.screen.select

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
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
import com.coby.kanji.ui.components.button.BackButton
import com.coby.kanji.ui.components.button.SelectButton
import com.coby.kanji.viewmodel.CharacterViewModel

@Composable
fun SelectScreen(
    screenState: ScreenState,
    onDismiss: () -> Unit,
    onShowDetail: (GradeType) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.mainbg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        )

        BackButton(
            modifier = Modifier
                .systemBarsPadding()
                .padding(16.dp)
                .align(Alignment.TopStart),
            onClick = {
                onDismiss()
            }
        )

        SelectView(
            modifier = Modifier
                .systemBarsPadding()
                .padding(horizontal = 16.dp)
                .padding(top = 82.dp)
                .align(Alignment.TopCenter),
            screenState = screenState,
            onSelectButtonClick = {
                onShowDetail(it)
            }
        )
    }
}

@Composable
fun SelectView(
    modifier: Modifier = Modifier,
    screenState: ScreenState,
    onSelectButtonClick: (GradeType) -> Unit,
    viewModel: CharacterViewModel = hiltViewModel()
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(GradeType.values().size) { index ->
            val grade = GradeType.values()[index]
            val total = viewModel.getTotal(screenState = screenState, gradeType = grade)
            val index = viewModel.getIndex(screenState = screenState, gradeType = grade)

            SelectButton(
                title = grade.title,
                index = index,
                total = total,
                onClick = {
                    onSelectButtonClick(grade)
                }
            )
        }
    }
}