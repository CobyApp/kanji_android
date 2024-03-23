package com.coby.kanji.screen.detail.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coby.kanji.ui.components.button.CloseButton
import com.coby.kanji.ui.components.button.CommonButton

@Composable
fun DetailTopAppBarView(onDismiss: () -> Unit, onShowGallery: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        CloseButton(
            onClick = onDismiss
        )

        Spacer(modifier = Modifier.weight(1f))

        CommonButton(
            modifier = Modifier
                .height(50.dp),
            text = "목록",
            onClick = onShowGallery
        )
    }
}