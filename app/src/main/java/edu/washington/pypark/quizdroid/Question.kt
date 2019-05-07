package edu.washington.pypark.quizdroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Question : AppCompatActivity() {

    private var currentQuestion: Int = 1
    private val questionChoices = arrayOf(arrayOf("chicken", "potato", "dog", "cat"), arrayOf("mango", "strawberry", "watermelon", "melon"))
    private val questions = arrayOf("What animal ate all the food?", "What food did the animal eat?")
    private lateinit var buttonClick: Button
    private lateinit var choice1: RadioButton
    private lateinit var choice2: RadioButton
    private lateinit var choice3: RadioButton
    private lateinit var choice4: RadioButton
    private lateinit var questionName: TextView
    private var answer: Int = -1
    private var answerText: String = ""
    private var correctAnswer: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question)
        setup()
        continuteButton()
        choiceSelection()
    }


    private fun continuteButton() {
        buttonClick?.setOnClickListener {
            val intent = Intent(this, Answer::class.java)
            intent.putExtra("answer", this.answer)
            intent.putExtra("answerText", this.answerText)
            intent.putExtra("currentQuestion", this.currentQuestion)
            intent.putExtra("totalQuestion", this.questions.size)
            intent.putExtra("correctAnswers", this.correctAnswer)

            startActivity(intent)
        }
    }

    private fun setup() {
        buttonClick = findViewById(R.id.button2)
        choice1 = findViewById(R.id.radioButton)
        choice2 = findViewById(R.id.radioButton2)
        choice3 = findViewById(R.id.radioButton3)
        choice4 = findViewById(R.id.radioButton4)
        questionName = findViewById(R.id.questionView)
        this.correctAnswer = intent.getIntExtra("correctAnswers", 0)
        this.currentQuestion = intent.getIntExtra("currentQuestion", 0)



        choice1.setText(questionChoices[currentQuestion][0])
        choice2.setText(questionChoices[currentQuestion][1])
        choice3.setText(questionChoices[currentQuestion][2])
        choice4.setText(questionChoices[currentQuestion][3])
        questionName.setText(questions[currentQuestion])

        buttonClick.setVisibility(View.INVISIBLE);

    }


    fun choiceSelection() {
        choice1.setOnClickListener {
            answer = 0
            buttonClick.setVisibility(View.VISIBLE);
            answerText = questionChoices[currentQuestion][0]
        }
        choice2.setOnClickListener {
            answer = 1
            buttonClick.setVisibility(View.VISIBLE);
            answerText = questionChoices[currentQuestion][1]

        }
        choice3.setOnClickListener {
            answer = 2
            buttonClick.setVisibility(View.VISIBLE);
            answerText = questionChoices[currentQuestion][2]
        }
        choice4.setOnClickListener {
            answer = 3
            buttonClick.setVisibility(View.VISIBLE);
            answerText = questionChoices[currentQuestion][3]

        }
    }
}