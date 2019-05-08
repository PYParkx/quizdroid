package edu.washington.pypark.quizdroid

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class QuestionFragment : Fragment() {

    private var quizNumber: Int = 0
    private var currentQuestion: Int = 0
    private var correctTotal : Int = 0
    private var questionTotal : Int = 0

    companion object {
        fun newInstance(quizNumber: Int, currentQuestionPosition: Int, correctTotal: Int, questionTotal: Int) = QuestionFragment().apply {
            arguments = Bundle().apply {
                putInt("quizNumber", quizNumber)
                putInt("currentQuestion", currentQuestionPosition)
                putInt("correctTotal", correctTotal)
                putInt("questionTotal", questionTotal)
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        arguments?.getInt("quizNumber")?.let { this.quizNumber = it }
        arguments?.getInt("currentQuestion")?.let { this.currentQuestion = it }
        arguments?.getInt("correctTotal")?.let { this.correctTotal = it }
        arguments?.getInt("questionTotal")?.let { this.questionTotal = it }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val main = inflater.inflate(R.layout.question_fragment, container, false)

        val questionView = main.findViewById<TextView>(R.id.questionTitle)
        val option1View = main.findViewById<TextView>(R.id.option1)
        val option2View = main.findViewById<TextView>(R.id.option2)
        val option3View = main.findViewById<TextView>(R.id.option3)
        val option4View = main.findViewById<TextView>(R.id.option4)
        val submitButton = main.findViewById<Button>(R.id.submitButton)
        val radioGroup = main.findViewById<RadioGroup>(R.id.radioGroup)

        val currentQuestionView = QuestionList.questionList(this.quizNumber)!![this.currentQuestion]
        questionView.text = currentQuestionView[0]
        option1View.text = currentQuestionView[1]
        option2View.text = currentQuestionView[2]
        option3View.text = currentQuestionView[3]
        option4View.text = currentQuestionView[4]

        radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                submitButton.visibility = View.VISIBLE
            }
        })
        submitButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val choice = main.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
                val correctAnswer = choice.text.toString().equals(currentQuestionView[5])
                if (correctAnswer) { correctTotal = correctTotal + 1 }

                val answerFragment : AnswerFragment = AnswerFragment.newInstance(quizNumber, currentQuestion, correctTotal, questionTotal.inc(), choice.text.toString(), currentQuestionView[5])
                val fragmentListener : FragmentChangeListener = activity as FragmentChangeListener
                fragmentListener.replaceFragment(answerFragment)
            }
        })
        return main
    }


}