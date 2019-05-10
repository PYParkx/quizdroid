package edu.washington.pypark.quizdroid

import java.io.Serializable

data class Question(val text: String, val possibleAnswers: Array<String>, val correctAnswer: Int) : Serializable
