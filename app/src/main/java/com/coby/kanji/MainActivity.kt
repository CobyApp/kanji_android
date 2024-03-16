package com.coby.kanji

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import com.coby.kanji.entity.ScreenState
import com.coby.kanji.screen.detail.DetailScreen
import com.coby.kanji.screen.gallery.GalleryScreen
import com.coby.kanji.screen.main.MainScreen
import com.coby.kanji.screen.select.SelectScreen
import com.coby.kanji.ui.theme.KanjiTheme
import com.coby.kanji.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                onBackButtonClick = {
                    navController.navigate("Main") {
                        popUpTo("Main") {
                            inclusive = true
                        }
                    }
                },
                onSelectButtonClick = {
                    navController.navigate("Detail")
                }
            )
        }

        composable(
            "Detail",
        ) {
            DetailScreen(
                screenState = screenState,
                onBackButtonClick = {
                    navController.navigate("Select") {
                        popUpTo("Select") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(
            "Gallery",
        ) {
            GalleryScreen(
                screenState = screenState,
                onBackButtonClick = {
                    navController.navigate("Detail") {
                        popUpTo("Detail") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}