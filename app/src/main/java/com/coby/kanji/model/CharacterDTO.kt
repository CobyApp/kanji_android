package com.coby.kanji.model

data class CharacterDTO(
    val grade: String,
    val kanji: String,
    val korean: String,
    val sound: String?,
    val meaning: String?,
    val word1: String?,
    val word2: String?
)