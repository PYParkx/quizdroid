package edu.washington.pypark.quizdroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class QuizActivity : AppCompatActivity(), FragmentChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        setup()
    }

    fun setup() {
        val quiz = intent.getStringExtra("quiz")
        val quizNumber = intent.getIntExtra("quizNumber", 0)
        val quizDesc = intent.getStringExtra("quizDesc")
        val overviewFragment : OverviewFragment = OverviewFragment.newInstance(quiz, quizDesc, quizNumber)
        val manager : FragmentManager = supportFragmentManager
        val transaction : FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.quizActivity, overviewFragment)
        transaction.commit()
    }

    override fun replaceFragment(fragmentOther: Fragment) {
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.quizActivity, fragmentOther).addToBackStack(null).commit()
    }
}