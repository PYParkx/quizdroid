package edu.washington.pypark.quizdroid

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class OverviewFragment : Fragment() {

    private lateinit var quizTitle : String
    private lateinit var quizDesc : String
    private var quizNumber : Int = 0
    private lateinit var questions : Array<Array<String>>

    companion object {
        fun newInstance(quiz: String, quizDesc: String, quizNumber: Int) = OverviewFragment().apply {
            arguments = Bundle().apply {
                putString("quiz", quiz)
                putString("quizDesc", quizDesc)
                putInt("quizNumber", quizNumber)
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        arguments?.getString("quiz")?.let { this.quizTitle = it }
        arguments?.getString("quizDesc")?.let { this.quizDesc = it }
        arguments?.getInt("quizNumber")?.let { this.quizNumber = it }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val main : View = inflater.inflate(R.layout.overview_fragment, container, false)

        val quizTitle = main.findViewById<TextView>(R.id.quizTitle)
        val quizDesc = main.findViewById<TextView>(R.id.QuizDesc)
        val totalQuestion = main.findViewById<TextView>(R.id.totalQuestion)

        this.questions = QuestionList.questionList(this.quizNumber)!!

        quizTitle.text = this.quizTitle
        quizDesc.text = this.quizDesc
        totalQuestion.text = this.questions.size.toString() + " questions"

        val beginButton = main.findViewById<Button>(R.id.beginButton)
        beginButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val questionFragment : QuestionFragment = QuestionFragment.newInstance(quizNumber, 0, 0, 0)
                val fragmentListener : FragmentChangeListener = activity as FragmentChangeListener
                fragmentListener.replaceFragment(questionFragment)
            }
        })
        return main
    }
}