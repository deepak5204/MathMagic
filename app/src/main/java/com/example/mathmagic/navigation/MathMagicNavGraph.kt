package com.example.mathmagic.navigation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mathmagic.component.ResultDialogBox
import com.example.mathmagic.navigation.MathMagicRoutes.ResultDialogBox
import com.example.mathmagic.screen.GameScreen
import com.example.mathmagic.screen.GameStartScreen
import com.example.mathmagic.screen.HomeScreen
import com.example.mathmagic.screen.ValidateAnswerScreen
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ModalBottomSheetLayout


@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterialNavigationApi::class,
    ExperimentalMaterialApi::class
)
@Composable
fun MathMagicNavGraph(
    modifier: Modifier = Modifier,
    startDestination: String
) {

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { true }
    )

    val bottomSheetNavigator = remember { BottomSheetNavigator(sheetState) }
    val navController = rememberNavController(bottomSheetNavigator)

    ModalBottomSheetLayout(
        bottomSheetNavigator = bottomSheetNavigator,
        sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ){
            composable(route = MathMagicRoutes.HomeScreen.route){
                HomeScreen(
                    modifier = modifier,
                    onBackClick = {},
                    onProceedClick = {  }
                )
            }
            composable(route = MathMagicRoutes.GameStartScreen.route){
                GameStartScreen(
                    modifier = modifier,
                    onBackClick = {},
                    onProceedClick = {  }
                )
            }
            composable(route = MathMagicRoutes.GameScreen.route){
                GameScreen(
                    modifier = modifier,
                    onBackClick = {},
                    onProceedClick = {  }
                )
            }
            composable(route = MathMagicRoutes.ValidateAnswerScreen.route){
                ValidateAnswerScreen(
                    modifier = modifier,
                    onBackClick = {},
                    onProceedClick = {  }
                )
            }
            composable(route = MathMagicRoutes.ResultDialogBox.route){
                ResultDialogBox(
                    modifier = modifier,
                    exitGame = {},
                    playAgain = {}
                   )
            }
        }
    }


}