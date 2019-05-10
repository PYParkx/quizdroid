package edu.washington.pypark.quizdroid

import java.io.Serializable

data class Quiz(val quizTitle: String, val quizDesc: String, val questions: Array<Question>) : Serializable