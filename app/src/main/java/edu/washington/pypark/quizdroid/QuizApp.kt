package edu.washington.pypark.quizdroid


import android.app.Application
import android.util.Log


class QuizApp : Application() {

    companion object {
        val topicRepository: TopicRepository = TopicRepository()
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("QUIZ APP", "App is connected")
    }
}
