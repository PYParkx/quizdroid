package edu.washington.pypark.quizdroid

class TopicRepository {

    private val questionBank = createData()

     fun getQuizzes(): ArrayList<String> {
        var names : ArrayList<String> = arrayListOf()
        this.questionBank.forEach { names.add(it.quizTitle) }
        return names
    }

     fun getQuiz(index: Int): Quiz {
        return this.questionBank[index]
    }

     fun getQuestions(index: Int): Array<Question> {
        return this.questionBank[index].questions
    }

    private fun createData(): ArrayList<Quiz> {
        val mathQuestion1 = Question("Who is Thanos?", arrayOf("What?", "Please stop", "Don't spoil!", "...."), 2)
        val mathQuestion2 = Question("Who is Spiderman?", arrayOf("Isn't this math??", "No", "Batman", "...."), 1)
        val physicsQuestion1 = Question("Square root of Spiderman", arrayOf("Thanos", "I don't feel so good.", "Here we go again!", "...."), 2)
        val physicsQuestion2 = Question("Ironman vs Thor?", arrayOf("Thor", "Batman", "Stop", "...."), 3)
        val marvelQuestion1 = Question("Thanos did what?", arrayOf("NO", "Don't do this", "Don't spoil!", "...."), 2)
        val marvelQuestion2 = Question("Thanos is spiderman", arrayOf("I'm done with this", "Okay?", "Liar!", "...."), 0)
        val math = Quiz("Math", "Let's do some math!", arrayOf(mathQuestion1, mathQuestion2))
        val physics = Quiz("Physics", "Let's do some physics", arrayOf(physicsQuestion1, physicsQuestion2))
        val marvel = Quiz("Marvel Super Heroes", "Avengers Unite!", arrayOf(marvelQuestion1, marvelQuestion2))
        return arrayListOf(math, physics, marvel)

    }
}
