package com.coby.kanji.screen.select

import androidx.compose.foundation.Image
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
            painter = painterResource(id = R.drawable.mainbg), // 배경 이미지 리소스
            contentDescription = null, // 접근성을 위한 설명 (배경 이미지이므로 null로 설정)
            modifier = Modifier.fillMaxSize(), // Box 컨테이너 전체 크기로 이미지를 설정
            contentScale = ContentScale.Crop // 이미지가 Box의 크기에 맞춰 잘리거나 늘어나도록 설정
        )

        BackButton(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.TopStart),
            onClick = {
                onBackButtonClick()
            }
        )

        SelectView(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(top = 90.dp)
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
            SelectButton(
                title = grade.title,
                index = 0,
                total = viewModel.getTotal(screenState = screenState, grade = grade),
                onClick = {
                    onSelectButtonClick()
                }
            )
        }
    }
}