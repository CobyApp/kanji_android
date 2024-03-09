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

enum class GradeType {
    one, two, three, four, five, six;

    val title: String
        get() = when(this) {
            one -> "초등학교 1학년"
            two -> "초등학교 2학년"
            three -> "초등학교 3학년"
            four -> "초등학교 4학년"
            five -> "초등학교 5학년"
            six -> "초등학교 6학년"
        }
}