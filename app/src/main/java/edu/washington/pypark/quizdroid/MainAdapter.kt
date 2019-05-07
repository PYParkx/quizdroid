package edu.washington.pypark.quizdroid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.quiz_item_row.view.*

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    val quizList = arrayOf("Math", "Physics", "Marvel Super Heroes")

    // number of items
    override fun getItemCount(): Int {
        return quizList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.quiz_item_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val quizTitles = quizList.get(position)
        holder.view.quiz_Title_View.text = quizTitles
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, Overview::class.java)
            view.context.startActivity(intent)
        }
    }
}