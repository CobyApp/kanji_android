package com.coby.kanji.entity

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