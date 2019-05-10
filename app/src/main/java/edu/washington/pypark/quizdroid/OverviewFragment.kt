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
    private lateinit var quizQuestions: Array<Question>
    private var quizNumber : Int = 0

    companion object {
        fun newInstance(quizTitle: String, quizDesc: String, quizNumber: Int) = OverviewFragment().apply {
            arguments = Bundle().apply {
                putString("quizTitle", quizTitle)
                putString("quizDesc", quizDesc)
                putInt("quizNumber", quizNumber)
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        arguments?.getString("quizTitle")?.let { this.quizTitle = it }
        arguments?.getString("quizDesc")?.let { this.quizDesc = it }
        arguments?.getInt("quizNumber")?.let { this.quizNumber = it }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val main : View = inflater.inflate(R.layout.overview_fragment, container, false)
        val quizTitle = main.findViewById<TextView>(R.id.quizTitle)
        val quizDesc = main.findViewById<TextView>(R.id.QuizDesc)
        val totalQuestion = main.findViewById<TextView>(R.id.totalQuestion)

        this.quizQuestions = QuizApp.topicRepository.getQuestions(quizNumber)
        quizTitle.text = this.quizTitle
        quizDesc.text = this.quizDesc
        totalQuestion.text = this.quizQuestions.size.toString() + " Questions in " + this.quizTitle + " Quiz"

        val beginButton = main.findViewById<Button>(R.id.beginButton)
        beginButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val questionFragment : QuestionFragment = QuestionFragment.newInstance(quizNumber, 0, 0, quizQuestions.size)
                val fragmentListener : FragmentChangeListener = activity as FragmentChangeListener
                fragmentListener.replaceFragment(questionFragment)
            }
        })
        return main
    }
}

