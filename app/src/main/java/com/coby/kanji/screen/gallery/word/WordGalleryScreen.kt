package com.coby.kanji.screen.gallery.word

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.coby.kanji.R
import com.coby.kanji.entity.GradeType
import com.coby.kanji.entity.ScreenState
import com.coby.kanji.entity.WordItem
import com.coby.kanji.screen.gallery.common.GalleryTopAppBarView
import com.coby.kanji.screen.gallery.common.GalleryWordView
import com.coby.kanji.viewmodel.CharacterViewModel

@Composable
fun WordGalleryScreen(
    gradeType: GradeType,
    onDismiss: () -> Unit,
    viewModel: CharacterViewModel = hiltViewModel()
) {
    val words: List<WordItem> = viewModel.getWordsByGrade(gradeType = gradeType)
    var currentIndex by remember { mutableStateOf(0) }
    val configuration = LocalConfiguration.current
    val gridState = rememberLazyGridState()

    LaunchedEffect(key1 = Unit) {
        currentIndex = viewModel.getIndex(screenState = ScreenState.word, gradeType = gradeType)
        gridState.scrollToItem(index = currentIndex)
    }

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

        val columns = if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            GridCells.Fixed(5)
        } else {
            GridCells.Fixed(3)
        }

        LazyVerticalGrid(
            modifier = Modifier.systemBarsPadding(),
            columns = columns,
            contentPadding = PaddingValues(
                top = 82.dp,
                bottom = 16.dp,
                start = 16.dp,
                end = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            state = gridState
        ) {
            itemsIndexed(words) { index, word ->
                GalleryWordView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clickable {
                            viewModel.saveIndex(
                                screenState = ScreenState.word,
                                gradeType = gradeType,
                                index = index
                            )
                            onDismiss()
                        },
                    kanji = word.wordKanji,
                    isChecked = currentIndex >= index
                )
            }
        }

        GalleryTopAppBarView(
            modifier = Modifier
                .systemBarsPadding()
                .padding(16.dp),
            text = "총 ${words.size}단어"
        ) {
            onDismiss()
        }
    }
}