package com.coby.kanji.screen.detail.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.coby.kanji.ui.components.button.LeftButton
import com.coby.kanji.ui.components.button.RightButton

@Composable
fun ArrowButtons(
    beforeIndex: () -> Unit,
    nextIndex: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LeftButton {
            beforeIndex()
        }

        Spacer(Modifier.weight(1f))

        RightButton {
            nextIndex()
        }
    }
}