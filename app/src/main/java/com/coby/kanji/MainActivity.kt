package com.coby.kanji

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coby.kanji.entity.GradeType
import com.coby.kanji.entity.ScreenState
import com.coby.kanji.screen.detail.kanji.KanjiDetailScreen
import com.coby.kanji.screen.detail.korean.KoreanDetailScreen
import com.coby.kanji.screen.detail.word.WordDetailScreen
import com.coby.kanji.screen.gallery.kanji.KanjiGalleryScreen
import com.coby.kanji.screen.gallery.korean.KoreanGalleryScreen
import com.coby.kanji.screen.gallery.word.WordGalleryScreen
import com.coby.kanji.screen.main.MainScreen
import com.coby.kanji.screen.select.SelectScreen
import com.coby.kanji.ui.theme.KanjiTheme
import com.coby.kanji.util.TTSManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        TTSManager.init(this)
        setContent {
            KanjiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopLevel()
                }
            }
        }
    }
}

@Composable
fun TopLevel(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    var screenState by remember { mutableStateOf(ScreenState.kanji) }
    var gradeType by remember { mutableStateOf(GradeType.one) }

    NavHost(
        navController = navController,
        "Main",
        modifier = modifier
    ) {
        composable("Main") {
            MainScreen(
                onStartButtonClick = {
                    screenState = it
                    navController.navigate("Select")
                }
            )
        }

        composable("Select") {
            SelectScreen(
                screenState = screenState,
                onDismiss = {
                    navController.navigate("Main") {
                        popUpTo("Main") {
                            inclusive = true
                        }
                    }
                },
                onShowDetail = {
                    gradeType = it
                    navController.navigate("Detail/${screenState.name}")
                }
            )
        }

        composable(
            "Detail/kanji",
        ) {
            KanjiDetailScreen(
                gradeType = gradeType,
                onDismiss = {
                    navController.navigate("Select") {
                        popUpTo("Select") {
                            inclusive = true
                        }
                    }
                },
                onShowGallery = {
                    navController.navigate( "Gallery/kanji")
                }
            )
        }

        composable(
            "Detail/korean",
        ) {
            KoreanDetailScreen(
                gradeType = gradeType,
                onDismiss = {
                    navController.navigate("Select") {
                        popUpTo("Select") {
                            inclusive = true
                        }
                    }
                },
                onShowGallery = {
                    navController.navigate( "Gallery/korean")
                }
            )
        }

        composable(
            "Detail/word",
        ) {
            WordDetailScreen(
                gradeType = gradeType,
                onDismiss = {
                    navController.navigate("Select") {
                        popUpTo("Select") {
                            inclusive = true
                        }
                    }
                },
                onShowGallery = {
                    navController.navigate( "Gallery/word")
                }
            )
        }

        composable(
            "Gallery/kanji",
        ) {
            KanjiGalleryScreen(
                gradeType = gradeType,
                onDismiss = {
                    navController.navigate("Detail/kanji") {
                        popUpTo("Detail/kanji") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(
            "Gallery/korean",
        ) {
            KoreanGalleryScreen(
                gradeType = gradeType,
                onDismiss = {
                    navController.navigate("Detail/korean") {
                        popUpTo("Detail/korean") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(
            "Gallery/word",
        ) {
            WordGalleryScreen(
                gradeType = gradeType,
                onDismiss = {
                    navController.navigate("Detail/word") {
                        popUpTo("Detail/word") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}