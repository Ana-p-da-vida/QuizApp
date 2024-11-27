package com.example.quizapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var optionsRadioGroup: RadioGroup
    private lateinit var nextButton: Button
    private lateinit var resultTextView: TextView

    private var currentQuestionIndex = 0
    private var score = 0

    private val questions = QuizData.getQuestions()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionTextView = findViewById(R.id.questionTextView)
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup)
        nextButton = findViewById(R.id.nextButton)
        resultTextView = findViewById(R.id.resultTextView)

        loadQuestion()

        nextButton.setOnClickListener {
            val selectedOptionId = optionsRadioGroup.checkedRadioButtonId
            if (selectedOptionId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedOptionId)
                val answer = selectedRadioButton.text.toString()

                if (questions[currentQuestionIndex].isCorrectAnswer(answer)) {
                    score++
                }

                currentQuestionIndex++
                if (currentQuestionIndex < questions.size) {
                    loadQuestion()
                } else {
                    showResult()
                }
            }
        }
    }

    private fun loadQuestion() {
        val question = questions[currentQuestionIndex]
        questionTextView.text = question.text
        optionsRadioGroup.removeAllViews()

        question.options.forEach { option ->
            val radioButton = RadioButton(this)
            radioButton.text = option
            optionsRadioGroup.addView(radioButton)
        }
    }

    private fun showResult() {
        questionTextView.text = "Quiz Finalizado!"
        resultTextView.text = "Você acertou $score de ${questions.size} perguntas."
        nextButton.visibility = View.GONE
        optionsRadioGroup.visibility = View.GONE
    }
}
