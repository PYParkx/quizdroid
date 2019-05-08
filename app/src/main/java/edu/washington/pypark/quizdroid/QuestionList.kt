package edu.washington.pypark.quizdroid

class QuestionList {
    companion object {
        val mathQuestions = arrayOf(
            arrayOf("Spider + Batman?", "Superman", "Chicken", "Potato", "Eagle", "Chicken"),
            arrayOf("No more math", "What?", "yes", "no", "Okay", "no"))

        val physicsQuestions = arrayOf(
            arrayOf("Let's do math ", "That's not physics", "YAY", "NOOO", "Thanos", "Thanos"),
            arrayOf("Worst Avenger?", "Thanos", "Iron Man", "Math", "Spiderman", "Math"))

        val marvelQuestions = arrayOf(
            arrayOf("Should the next question spoil the movie?", "YEESS", "No.", "I'll fail you.", "....", "...."),
            arrayOf("Antman wins?", "LOL", "How dare you!", "...", "Okay", "LOL"))

        fun questionList(quizNumber: Int):Array<Array<String>>? {
            when (quizNumber) {
                0 -> return mathQuestions
                1 -> return physicsQuestions
                2 -> return marvelQuestions
            }
            return null
        }
    }
}