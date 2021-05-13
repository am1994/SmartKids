package com.example.smartkids.model

import com.example.smartkids.R
import com.example.smartkids.setQuestionsList

//list of all colors lists
private lateinit var sourceColorsList: MutableList<Int>

private lateinit var sourceBlack: MutableList<Int>
private lateinit var sourceBlue: MutableList<Int>
private lateinit var sourceBrown: MutableList<Int>
private lateinit var sourceGreen: MutableList<Int>
private lateinit var sourceOrange: MutableList<Int>
private lateinit var sourcePink: MutableList<Int>
private lateinit var sourceRed: MutableList<Int>
private lateinit var sourceViolet: MutableList<Int>
private lateinit var sourceWhite: MutableList<Int>
private lateinit var sourceYellow: MutableList<Int>


private lateinit var colorObjectsList:MutableList<List<Int>>

 private fun resetColorLists(){
    sourceColorsList = mutableListOf(
        R.drawable.black,
        R.drawable.blue,
        R.drawable.brown,
        R.drawable.green,
        R.drawable.orange,
        R.drawable.pink,
        R.drawable.red,
        R.drawable.violet,
        R.drawable.yellow)
    sourceBlack = mutableListOf(
        R.drawable.black_1,
        R.drawable.black_2,
        R.drawable.black_3
    )
    sourceBlue = mutableListOf(
        R.drawable.blue_1,
        R.drawable.blue_2,
        R.drawable.blue_3
    )
    sourceBrown = mutableListOf(
        R.drawable.brown_1,
        R.drawable.brown_2,
        R.drawable.brown_3
    )
    sourceGreen = mutableListOf(
        R.drawable.green_1,
        R.drawable.green_2,
        R.drawable.green_3
    )
    sourceOrange = mutableListOf(
        R.drawable.orange_1,
        R.drawable.orange_2,
        R.drawable.orange_3
    )
    sourcePink = mutableListOf(
        R.drawable.pink_1,
        R.drawable.pink_2,
        R.drawable.pink_3
    )
    sourceRed = mutableListOf(
        R.drawable.red_1,
        R.drawable.red_2,
        R.drawable.red_3
    )
    sourceViolet = mutableListOf(
        R.drawable.violet_1,
        R.drawable.violet_2,
        R.drawable.violet_3
    )
    sourceWhite = mutableListOf(
        R.drawable.white_1,
        R.drawable.white_2,
        R.drawable.white_3
    )
    sourceYellow = mutableListOf(
        R.drawable.yellow_1,
        R.drawable.yellow_2,
        R.drawable.yellow_3
    )
    colorObjectsList = mutableListOf(
        sourceBlack,
        sourceBlue,
        sourceBrown,
        sourceGreen,
        sourceOrange,
        sourcePink,
        sourceRed,
        sourceViolet,
        sourceYellow
    )
}

//Shuffle color object lists
 private fun resetColorObjectsLists(){
    sourceBlack.shuffle()
    sourceBlue.shuffle()
    sourceBrown.shuffle()
    sourceGreen.shuffle()
    sourceOrange.shuffle()
    sourcePink.shuffle()
    sourceRed.shuffle()
    sourceViolet.shuffle()
    sourceWhite.shuffle()
}
//color question list
private   var colorQuestions: MutableList<Question> = mutableListOf()

fun startColorGamePart():MutableList<Question>{
    colorQuestions.clear()
    resetColorLists()
    resetColorObjectsLists()
   //colorQuestions =
    return setQuestionsList(sourceColorsList, colorObjectsList, colorQuestions)
}
