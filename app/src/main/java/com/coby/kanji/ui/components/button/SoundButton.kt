package com.coby.kanji.ui.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.coby.kanji.R

@Composable
fun SoundButton(
    modifier: Modifier = Modifier,
    isOn: Boolean,
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
            painter = painterResource(id = if (isOn) R.drawable.volume_up else R.drawable.volume_off),
            contentDescription = "Sound",
            tint = Color.White
        )
    }
}