package com.coby.kanji.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun SelectButton(
    modifier: Modifier = Modifier,
    title: String,
    index: Int,
    total: Int,
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
        shape = RoundedCornerShape(20.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontFamily = Ownglyph,
                    fontSize = 20.sp
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "${index + 1}/$total",
                style = TextStyle(
                    fontFamily = Ownglyph,
                    fontSize = 20.sp
                )
            )
        }
    }
}