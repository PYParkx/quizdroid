package edu.washington.pypark.quizdroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var quizList : ArrayList<String> = arrayListOf("Math", "Physics", "Marvel Super Heroes")
    private var quizListDesc : ArrayList<String> = arrayListOf("Let's do math!", "Let's do Physics", "Avengers Unite!")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val quizListView: ListView = findViewById(R.id.quizList)

        val adapter : ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, this.quizList)
        quizListView.adapter = adapter

        quizListView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val intent = Intent(this@MainActivity, QuizActivity::class.java)
                intent.putExtra("quiz", quizList[position])
                intent.putExtra("quizNumber", position)
                intent.putExtra("quizDesc", quizListDesc[position])
                startActivity(intent)
            }
        }
    }

}


