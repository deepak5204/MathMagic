package com.example.mathmagic.navigation

sealed class MathMagicRoutes(val route: String){
    data object HomeScreen: MathMagicRoutes("homScreen")
    data object GameStartScreen: MathMagicRoutes("gameStartScreen")
    data object GameScreen: MathMagicRoutes("gameScreen")
    data object ValidateAnswerScreen: MathMagicRoutes("validateAnswerScreen")
    data object ResultDialogBox: MathMagicRoutes("resultDialogBox")
}