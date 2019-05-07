package edu.washington.pypark.quizdroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Overview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.overview)
        startButton()
    }

    fun startButton() {
        val buttonClick: Button = findViewById(R.id.button)
        buttonClick?.setOnClickListener {
            val intent = Intent(this, Question::class.java)
            startActivity(intent)
        }
    }

}