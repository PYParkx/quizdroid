package edu.washington.pypark.quizdroid

import java.io.Serializable

data class Answer(val text: String, val correctAnswer: String,
                  val totalCorrect: Int, val nextQuestion: Int, val totalQuestions: Int) : Serializable
