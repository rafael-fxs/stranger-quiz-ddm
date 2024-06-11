package com.example.strangerquiz.model

data class Question(
    val id: Int,
    val description: String,
    val drawable: Int,
    val options: List<Option>,
)

data class Option (
    val answer: String,
    val correct: Boolean,
)