package edu.washington.pypark.quizdroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var quizList : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.quizList = findViewById(R.id.quizList)
        val quizzes = QuizApp.topicRepository.getQuizzes()
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, quizzes)
        this.quizList.adapter = adapter
        this.quizList.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val intent = Intent(this@MainActivity, QuizActivity::class.java)
                intent.putExtra("index", position)
                startActivity(intent)
            }
        }
    }

}

