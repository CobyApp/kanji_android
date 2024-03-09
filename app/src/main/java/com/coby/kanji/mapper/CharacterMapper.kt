package com.coby.kanji.mapper

import com.coby.kanji.entity.Character
import com.coby.kanji.entity.GradeType
import com.coby.kanji.entity.WordItem
import com.coby.kanji.model.CharacterDTO

fun CharacterDTO.toCharacter(): Character = Character(
    grade = this.getGradeType(),
    kanji = this.kanji,
    korean = this.korean,
    sounds = this.sound?.split(",") ?: emptyList<String>(),
    meanings = this.meaning?.split(",") ?: emptyList<String>(),
    words1 = this.getWords1(),
    words2 = this.getWords2()
)

fun CharacterDTO.getGradeType(): GradeType {
    return when (this.grade) {
        "초등학교 1학년" -> GradeType.one
        "초등학교 2학년" -> GradeType.two
        "초등학교 3학년" -> GradeType.three
        "초등학교 4학년" -> GradeType.four
        "초등학교 5학년" -> GradeType.five
        "초등학교 6학년" -> GradeType.six
        else -> throw IllegalArgumentException("Unknown grade")
    }
}

fun CharacterDTO.getWords1(): List<WordItem> {
    val words = this.word1?.split("&") ?: emptyList<String>()
    return words.map {
        val words = it.split("] ")
        WordItem(
            word = "${words.firstOrNull() ?: ""}]",
            mean = words.getOrNull(1) ?: ""
        )
    }
}

fun CharacterDTO.getWords2(): List<WordItem> {
    val words = this.word2?.split("&") ?: emptyList<String>()
    return words.map {
        val words = it.split("] ")
        WordItem(
            word = "${words.firstOrNull() ?: ""}]",
            mean = words.getOrNull(1) ?: ""
        )
    }
}