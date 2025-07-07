package com.example.mathmagic.navigation

import com.example.mathmagic.MainActivity.Companion.SELECTED_OPERATION

sealed class MathMagicRoutes(val route: String){
    data object HomeScreen: MathMagicRoutes("homScreen")
    data object GameStartScreen: MathMagicRoutes("gameStartScreen/{${SELECTED_OPERATION}}") {
        fun buildRoute(selectedOperation: String) : String = "gameStartScreen/$selectedOperation"
    }
    data object GameScreen: MathMagicRoutes("gameScreen")
    data object ValidateAnswerScreen: MathMagicRoutes("validateAnswerScreen")
    data object ResultDialogBox: MathMagicRoutes("resultDialogBox")
}