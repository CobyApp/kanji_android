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
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coby.kanji.screen.DetailScreen
import com.coby.kanji.screen.main.MainScreen
import com.coby.kanji.ui.theme.KanjiTheme
import com.coby.kanji.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: CharacterViewModel by viewModels()

        viewModel.characters.forEach { character ->
            Log.d("캐릭터", character.toString())
        }

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
    NavHost(
        navController = navController,
        "Main",
        modifier = modifier
    ) {
        composable("Main") {
            MainScreen(
                onDetailButtonClick = {
                    val state = it
                    navController.navigate("Detail/${state}")
                }
            )
        }

        composable(
            "Detail/{state}",
        ) {
            DetailScreen(
                state = "kanji",
                onBackButtonClick = {
                    navController.navigate("Main") {
                        popUpTo("Main") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}