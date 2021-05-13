package com.example.smartkids.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.smartkids.TYPES
import com.example.smartkids.model.Question
import com.example.smartkids.model.startColorGamePart
import com.example.smartkids.model.startShapeGamePart



class GameViewModel (val  type:TYPES): ViewModel() {

    //questions list
    private   var questions: MutableList<Question> = mutableListOf()


    private var _shape= MutableLiveData<Int>()
    val shape: LiveData<Int>
        get() = _shape

    private var _object1= MutableLiveData<Int>()
    val object1: LiveData<Int>
        get() = _object1

    private var _object2= MutableLiveData<Int>()
    val object2: LiveData<Int>
        get() = _object2

    private var _object3= MutableLiveData<Int>()
    val object3: LiveData<Int>
        get() = _object3


    private var _navigateToResult= MutableLiveData<Boolean>()
    val navigateToResult : LiveData<Boolean>
        get() = _navigateToResult

    private var _correctAnswer= MutableLiveData<Boolean>()
    val correctAnswer: LiveData<Boolean>
        get() = _correctAnswer

    var score = 0
    private var _scoreBoard= MutableLiveData<String>()
    val scoreBoard: LiveData<String>
        get() = _scoreBoard


    private lateinit var currentQuestion : Question
    private lateinit var answers:MutableList<Int>
    private  var questionIndex = 0
    private var  numQuestion = 0

    private fun randomizeQuestion(){
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun  setQuestion(){
        currentQuestion=questions[questionIndex]
        _shape.postValue(currentQuestion.shape)
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()

        _object1.postValue(answers[0])
        _object2.postValue(answers[1])
        _object3.postValue(answers[2])
    }



    private fun restart(){
        questions.clear()
        questions = if(type == TYPES.COlOR){
            startColorGamePart()
        }else {
            startShapeGamePart()
        }
        randomizeQuestion()
        numQuestion= questions.size

        _scoreBoard.postValue("0")
    }
    init {
        restart()
    }

    fun  onClickEvent(answerIndex: Int){
        checkAnswer(answerIndex)
    }


    private fun checkAnswer(answerIndex: Int) {
        if (answers[answerIndex] == currentQuestion.answers[0]) {
            _correctAnswer.postValue(true)
            score += 10
            _scoreBoard.postValue(score.toString())
            questionIndex++

            if (questionIndex < numQuestion) {
                currentQuestion = questions[questionIndex]
                setQuestion()
            } else {
                _navigateToResult.postValue(true)
            }
        }else{
            _correctAnswer.postValue(false)

            score-=10

            _navigateToResult.postValue(false)
        }

    }




    fun onNavigationCompleted(){
        _navigateToResult.postValue(false)
    }

}



