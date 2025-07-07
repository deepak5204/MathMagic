package com.example.mathmagic.navigation

import com.example.mathmagic.MainActivity.Companion.SELECTED_OPERATION
import com.example.mathmagic.MainActivity.Companion.TIME_DIFFERENCE
import com.example.mathmagic.MainActivity.Companion.TOTAL_VALUE

sealed class MathMagicRoutes(val route: String){
    data object HomeScreen: MathMagicRoutes("homScreen")
    data object GameStartScreen: MathMagicRoutes("gameStartScreen/{${SELECTED_OPERATION}}") {
        fun buildRoute(selectedOperation: String) : String = "gameStartScreen/$selectedOperation"
    }
    data object GameScreen : MathMagicRoutes("gameScreen/{$TOTAL_VALUE}/{$TIME_DIFFERENCE}") {
        fun buildRoute(totalValue: String, timeDifference: String): String =
            "gameScreen/$totalValue/$timeDifference"
    }

    data object ValidateAnswerScreen: MathMagicRoutes("validateAnswerScreen")
    data object ResultDialogBox: MathMagicRoutes("resultDialogBox")
}