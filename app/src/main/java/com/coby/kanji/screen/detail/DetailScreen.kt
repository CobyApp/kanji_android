package com.coby.kanji.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coby.kanji.R
import com.coby.kanji.entity.ScreenState
import com.coby.kanji.ui.components.BackButton
import com.coby.kanji.ui.components.CloseButton
import com.coby.kanji.ui.components.CommonButton

@Composable
fun DetailScreen(
    screenState: ScreenState,
    onBackButtonClick: () -> Unit,
    onGalleryButtonClick: () -> Unit
) {
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

        CloseButton(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart),
            onClick = {
                onBackButtonClick()
            }
        )

        CommonButton(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopEnd)
                .width(80.dp)
                .height(50.dp),
            text = "목록",
            onClick = {
                onBackButtonClick()
            }
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
        }
    }
}