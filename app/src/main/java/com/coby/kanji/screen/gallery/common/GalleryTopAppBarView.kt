package com.coby.kanji.screen.gallery.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coby.kanji.ui.components.button.BackButton
import com.coby.kanji.ui.components.button.CloseButton
import com.coby.kanji.ui.components.button.CommonButton
import com.coby.kanji.ui.theme.Ownglyph

@Composable
fun GalleryTopAppBarView(
    modifier: Modifier = Modifier,
    text: String,
    onDismiss: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        BackButton(
            onClick = onDismiss
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(50.dp)
                .background(
                    color = Color.Black.copy(alpha = 0.8F),
                    shape = RoundedCornerShape(25.dp)
                )
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontFamily = Ownglyph,
                    fontSize = 20.sp
                ),
                color = Color.White,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
    }
}