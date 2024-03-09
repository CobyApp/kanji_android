package com.coby.kanji.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coby.kanji.entity.Character
import com.coby.kanji.entity.GradeType
import com.coby.kanji.entity.WordItem
import com.coby.kanji.mapper.toCharacter
import com.coby.kanji.model.CharacterDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterList: List<CharacterDTO>
) : ViewModel() {
    val characters = mutableStateListOf<Character>()

    fun getCharacters() {
        characters.clear()
        viewModelScope.launch {
            val result = characterList.map { it.toCharacter() }
            characters.addAll(result)
        }
    }

    fun getCharactersByGrade(grade: GradeType): List<Character> {
        return characters.filter { it.grade == grade }
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

    fun getWordsByGrade(grade: GradeType): List<WordItem> {
        return getCharactersByGrade(grade).flatMap { it.words1 + it.words2 }
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