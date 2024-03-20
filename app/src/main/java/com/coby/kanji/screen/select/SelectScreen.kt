package com.coby.kanji.screen.select

import android.content.Context.MODE_PRIVATE
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
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
import com.coby.kanji.mapper.getGradeType
import com.coby.kanji.ui.components.BackButton
import com.coby.kanji.ui.components.SelectButton
import com.coby.kanji.viewmodel.CharacterViewModel

@Composable
fun SelectScreen(
    screenState: ScreenState,
    onBackButtonClick: () -> Unit,
    onSelectButtonClick: () -> Unit
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
                .padding(16.dp)
                .align(Alignment.TopStart),
            onClick = {
                onBackButtonClick()
            }
        )

        SelectView(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 82.dp)
                .align(Alignment.TopCenter),
            screenState = screenState,
            onSelectButtonClick = {
                onSelectButtonClick()
            }
        )
    }
}

@Composable
fun SelectView(
    modifier: Modifier = Modifier,
    screenState: ScreenState,
    onSelectButtonClick: () -> Unit,
    viewModel: CharacterViewModel = hiltViewModel()
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(GradeType.values().size) { index ->
            val grade = GradeType.values()[index]
            val total = viewModel.getTotal(screenState = screenState, grade = grade)
            val index = viewModel.getIndex(screenState = screenState, grade = grade)

            SelectButton(
                title = grade.title,
                index = index,
                total = total,
                onClick = {
                    onSelectButtonClick()
                }
            )
        }
    }
}