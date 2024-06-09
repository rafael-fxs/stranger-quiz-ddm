package com.example.strangerquiz.models

import java.math.BigDecimal

data class Question(
    val id: Int,
    val description: String,
    val imageUrl: String,
    val options: List<Option>,
)

data class Option (
    val answer: String,
    val correct: Boolean,
)