package com.coby.kanji.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(50.dp)
            .background(
                color = Color.Black.copy(alpha = 0.8F),
                shape = CircleShape
            )
            .clickable(onClick = onClick)
    ) {
        Icon(
            imageVector = Icons.Filled.KeyboardArrowLeft,
            contentDescription = "Back",
            tint = Color.White
        )
    }
}