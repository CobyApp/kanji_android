package com.coby.kanji.ui.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coby.kanji.ui.theme.Ownglyph

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black.copy(alpha = 0.8F),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(30.dp),
        onClick = onClick
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = Ownglyph,
                fontSize = 20.sp
            )
        )
    }
}