package com.coby.kanji.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(
    state: String,
    onBackButtonClick: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        Button(
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(30.dp),
            enabled = true,
            onClick = {
                onBackButtonClick()
            }
        ) {
            Text("뒤로가기")
        }
    }
}