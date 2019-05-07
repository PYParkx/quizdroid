package edu.washington.pypark.quizdroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Answer : AppCompatActivity() {

    private lateinit var answerText: TextView
    private lateinit var correctAnswer: TextView
    private lateinit var score: TextView
    private lateinit var button: Button

    private var totalQuestion: Int = 0
    private var correctAnswerTotal: Int = 0

    private var currentQuestion: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.answer)
        setup()
        buttonClick()
    }

    fun setup() {
        answerText = findViewById(R.id.userAnswer)
        score = findViewById(R.id.score)
        button = findViewById(R.id.button3)
        totalQuestion = intent.getIntExtra("totalQuestion", 0)
        currentQuestion = intent.getIntExtra("currentQuestion", 0)
        correctAnswerTotal = intent.getIntExtra("correctAnswer", 0)
        answerText.setText(intent.getStringExtra("answerText"))
        score.setText("You have " + this.correctAnswerTotal + " out of " + this.totalQuestion)
        buttonPath()
    }

    fun buttonPath() {
        currentQuestion = currentQuestion + 1
        if (this.totalQuestion == this.currentQuestion) {
            button.setText("Finish")

            button.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        } else {
            button.setText("Next")

            button.setOnClickListener {
                val intent = Intent(this, Question::class.java)
                intent.putExtra("currentQuestion", this.currentQuestion)
                intent.putExtra("correctAnswers", this.correctAnswerTotal)
                startActivity(intent)
            }
        }
    }

    fun buttonClick() {


    }
}