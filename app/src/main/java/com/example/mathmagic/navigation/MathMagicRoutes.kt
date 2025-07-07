package com.example.mathmagic.navigation

import com.example.mathmagic.MainActivity.Companion.CALCULATED_VALUE
import com.example.mathmagic.MainActivity.Companion.FINAL_ANSWER
import com.example.mathmagic.MainActivity.Companion.INITIAL_VALUE
import com.example.mathmagic.MainActivity.Companion.SELECTED_OPERATION
import com.example.mathmagic.MainActivity.Companion.TIME_DIFFERENCE
import com.example.mathmagic.MainActivity.Companion.TOTAL_VALUE

sealed class MathMagicRoutes(val route: String){
    data object HomeScreen: MathMagicRoutes("homScreen")
    data object GameStartScreen: MathMagicRoutes("gameStartScreen/{${SELECTED_OPERATION}}") {
        fun buildRoute(selectedOperation: String) : String = "gameStartScreen/$selectedOperation"
    }
    data object GameScreen : MathMagicRoutes("gameScreen/{$TOTAL_VALUE}/{$TIME_DIFFERENCE}/{$INITIAL_VALUE}") {
        fun buildRoute(totalValue: String, timeDifference: String, initialValue: String): String =
            "gameScreen/$totalValue/$timeDifference/$initialValue"
    }

    data object ValidateAnswerScreen: MathMagicRoutes("validateAnswerScreen/{$CALCULATED_VALUE}"){
        fun buildRoute(calculateAnswer: String): String = "validateAnswerScreen/$calculateAnswer"
    }

    data object ResultDialogBox: MathMagicRoutes("resultDialogBox/{$FINAL_ANSWER}/{$CALCULATED_VALUE}"){
        fun buildRoute(finalAnswer: String, calculateAnswer: String): String = "resultDialogBox/$finalAnswer/$calculateAnswer"
    }
}