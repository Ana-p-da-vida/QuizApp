package com.example.quizapp


object QuizData {
    fun getQuestions(): List<Question> {
        return listOf(
            Question(
                "O que simboliza a rosa vermelha na floriografia?",
                listOf("Amor apaixonado", "Felicidade", "Amizade", "Luto"),
                "Amor apaixonado"
            ),
            Question(
                "Qual flor simboliza a paz?",
                listOf("Margarida", "Lírio da paz", "Rosa branca", "Orquídea"),
                "Lírio da paz"
            ),
            Question(
                "O que significa o cravo amarelo?",
                listOf("Amizade", "Desprezo", "Solidariedade", "Felicidade"),
                "Desprezo"
            )
        )
    }
}
