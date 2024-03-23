package com.coby.kanji.ui.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LeftButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier
            .size(50.dp)
            .background(Color.Black.copy(alpha = 0.8f), shape = CircleShape),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Left",
            tint = Color.White
        )
    }
}