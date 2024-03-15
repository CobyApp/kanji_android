package com.coby.kanji.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coby.kanji.R
import com.coby.kanji.entity.ScreenState

@Composable
fun DetailScreen(
    screenState: ScreenState,
    onBackButtonClick: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.detailbg), // 배경 이미지 리소스
            contentDescription = null, // 접근성을 위한 설명 (배경 이미지이므로 null로 설정)
            modifier = Modifier.fillMaxSize(), // Box 컨테이너 전체 크기로 이미지를 설정
            contentScale = ContentScale.Crop // 이미지가 Box의 크기에 맞춰 잘리거나 늘어나도록 설정
        )

        Column(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(
                onClick = {
                    onBackButtonClick()
                }
            ) {
                Text("뒤로가기")
            }
        }
    }
}