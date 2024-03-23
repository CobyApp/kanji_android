package com.coby.kanji.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coby.kanji.entity.Character
import com.coby.kanji.entity.GradeType
import com.coby.kanji.entity.ScreenState
import com.coby.kanji.entity.WordItem
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val characters: List<Character>
) : ViewModel() {
    private val _characterState = MutableStateFlow<List<Character>>(emptyList())
    val characterState: StateFlow<List<Character>> = _characterState

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("index", Context.MODE_PRIVATE)

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            _characterState.value = characters
        }
    }

    fun getTotal(screenState: ScreenState, gradeType: GradeType): Int {
        return when (screenState) {
            ScreenState.kanji, ScreenState.korean -> getCharactersByGrade(gradeType = gradeType).count()
            ScreenState.word -> getWordsByGrade(gradeType = gradeType).count()
        }
    }

    fun getIndex(screenState: ScreenState, gradeType: GradeType): Int {
        return sharedPreferences.getInt(screenState.name + gradeType.name, 0)
    }

    fun saveIndex(screenState: ScreenState, gradeType: GradeType, index: Int) {
        sharedPreferences.edit().apply {
            putInt(screenState.name + gradeType.name, index)
            apply()
        }
    }

    fun getCount(screenState: ScreenState, word: String): Int {
        return sharedPreferences.getInt(screenState.name + word, 0)
    }

    fun saveCount(screenState: ScreenState, word: String, count: Int) {
        sharedPreferences.edit().apply {
            putInt(screenState.name + word, count)
            apply()
        }
    }

    fun getCharactersByGrade(gradeType: GradeType): List<Character> {
        return characters.filter { it.grade == gradeType }
    }

    fun getRandomCharacters(): List<Character> {
        val shuffledCharacters = characters.shuffled()
        return shuffledCharacters.take(3)
    }

    fun getRandomKoreans(korean: String): List<String> {
        var quizItems = getRandomCharacters().map { it.korean }
        quizItems = quizItems + korean
        return quizItems.shuffled()
    }

    fun getAllWordItems(): List<WordItem> {
        return characters.flatMap { it.words1 + it.words2 }
    }

    fun getWordsByGrade(gradeType: GradeType): List<WordItem> {
        return getCharactersByGrade(gradeType).flatMap { it.words1 + it.words2 }
    }

    fun getRandomWordItems(): List<WordItem> {
        val shuffledWords = getAllWordItems().shuffled()
        return shuffledWords.take(3)
    }

    fun getRandomWordSounds(wordSound: String): List<String> {
        var quizItems = getRandomWordItems().map { it.wordSound }
        quizItems = quizItems + wordSound
        return quizItems.shuffled()
    }
}