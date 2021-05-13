package com.example.smartkids.model

import com.example.smartkids.R
import com.example.smartkids.setQuestionsList

//list of all shape lists
 lateinit var sourceShapeList: MutableList<Int>

private lateinit var sourceTriangles: MutableList<Int>
private lateinit var sourceCircles: MutableList<Int>
private lateinit var sourceSemiCircles: MutableList<Int>
private lateinit var sourceOvals: MutableList<Int>
private lateinit var sourcePolygons: MutableList<Int>
private lateinit var sourceRectangles: MutableList<Int>
private lateinit var sourceSquares: MutableList<Int>
private lateinit var sourceStars: MutableList<Int>
private lateinit var sourceTrapezoids: MutableList<Int>

private lateinit var shapeObjectsList:MutableList<List<Int>>



 private fun resetShapeLists() {
    sourceShapeList = mutableListOf(
        R.drawable.triangle_1,
        R.drawable.circle_2,
        R.drawable.semicircle_3,
        R.drawable.oval_4,
        // R.drawable.polygon_5,
        R.drawable.rectangle_6,
        R.drawable.square_7,
        R.drawable.star_8,
        R.drawable.trapezoidal_9
    )
    sourceTriangles = mutableListOf(
        R.drawable.triangle_1_1,
        R.drawable.triangle_1_2,
        R.drawable.triangle_1_3
    )

    sourceCircles = mutableListOf(
        R.drawable.circle_2_1,
        R.drawable.circle_2_2,
        R.drawable.circle_2_3
    )
    sourceSemiCircles = mutableListOf(
        R.drawable.semicircle_3_1,
        R.drawable.semicircle_3_2,
        R.drawable.semicircle_3_3
    )
    sourceOvals = mutableListOf(
        R.drawable.oval_4_1,
        R.drawable.oval_4_2,
        R.drawable.oval_4_3
    )
    sourcePolygons = mutableListOf()
    sourceRectangles = mutableListOf(
        R.drawable.rectangle_6_1,
        R.drawable.rectangle_6_2,
        R.drawable.rectangle_6_3
    )
    sourceSquares = mutableListOf(
        R.drawable.square_7_1,
        R.drawable.square_7_2,
        R.drawable.square_7_3
    )
    sourceStars = mutableListOf(
        R.drawable.star_8_1,
        R.drawable.star_8_2,
        R.drawable.star_8_3
    )
    sourceTrapezoids = mutableListOf(
        R.drawable.trapezoidal_9_1,
        R.drawable.trapezoidal_9_2,
        R.drawable.trapezoidal_9_3
    )

    //list of color object lists
    shapeObjectsList = mutableListOf(
        sourceTriangles,
        sourceCircles,
        sourceSemiCircles,
        sourceOvals,
        // sourcePolygons,
        sourceRectangles,
        sourceSquares,
        sourceStars,
        sourceTrapezoids
    )

}

 private fun resetShapeObjectsLists(){
    sourceTriangles.shuffle()
    sourceCircles.shuffle()
    sourceSemiCircles.shuffle()
    sourceOvals.shuffle()
    // sourcePolygons.shuffle()
    sourceRectangles.shuffle()
    sourceSquares.shuffle()
    sourceStars.shuffle()
    sourceTrapezoids.shuffle()
}

//color question list
private   var shapeQuestions: MutableList<Question> = mutableListOf()

fun startShapeGamePart():MutableList<Question>{
    shapeQuestions.clear()
    resetShapeLists()
    resetShapeObjectsLists()
    shapeQuestions = setQuestionsList(sourceShapeList, shapeObjectsList, shapeQuestions)
    return shapeQuestions
}