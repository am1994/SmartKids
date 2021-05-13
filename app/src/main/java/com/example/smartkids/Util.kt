package com.example.smartkids

import android.util.Log
import com.example.smartkids.model.Question
import kotlin.random.Random

enum class TYPES {
    COlOR,
    SHAPE
}

     fun setQuestionsList(
        sourceList: MutableList<Int>, objectsList: MutableList<List<Int>>,
        questions: MutableList<Question>):MutableList<Question> {
        for (i in sourceList.indices) {
            val question: Int = sourceList[i]
            val answer: Int = objectsList[i][0]

            val list = objectsList.toMutableList()
            list.removeAt(i)
            Log.i("size of list","${list.size}")
            val firstWrongAnswer: Int = list[Random.nextInt(list.size)][Random.nextInt(3)]
            list.shuffle()
            val secondWrongAnswer: Int = list[Random.nextInt(list.size)][Random.nextInt(3)]
            questions.add(
                Question(
                    question,
                    listOf(answer, firstWrongAnswer, secondWrongAnswer)
                )
            )

        }
         return questions

    }

