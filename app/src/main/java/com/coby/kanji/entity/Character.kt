package com.coby.kanji.entity

data class Character(
    val grade: GradeType,
    val kanji: String,
    val korean: String,
    val sounds: List<String>,
    val meanings: List<String>,
    val words1: List<WordItem>,
    val words2: List<WordItem>
) {
    val fullSound: String
        get() = sounds.joinToString(separator = ", ")

    val fullMeaning: String
        get() = meanings.joinToString(separator = ", ")
}

data class WordItem(
    val word: String,
    val mean: String
) {
    val wordKanji: String
        get() = word.split("[").firstOrNull() ?: ""

    val wordSound: String
        get() = word.split("[").lastOrNull()?.split("]")?.firstOrNull() ?: ""
}