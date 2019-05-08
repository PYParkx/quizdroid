package edu.washington.pypark.quizdroid

import androidx.fragment.app.Fragment

interface FragmentChangeListener {
    fun replaceFragment(fragmentOther: Fragment)
}