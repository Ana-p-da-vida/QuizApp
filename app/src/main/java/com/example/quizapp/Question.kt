package com.example.quizapp
data class Question(
    val text: String,
    val options: List<String>,
    private val correctAnswer: String
) {
    fun isCorrectAnswer(answer: String): Boolean {
        return answer == correctAnswer
    }
}
