package com.example.mathmagic.navigation

import android.util.Log
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mathmagic.MainActivity.Companion.SELECTED_OPERATION
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
    startDestination: String,
    onFinish: () -> Unit
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
                    onBackClick = {
                        onFinish()
                    },
                    onProceedClick = { selectedOperation ->
                        Log.d("TAG", "MathMagicNavGraph: $selectedOperation")
                        navController.navigate(route = MathMagicRoutes.GameStartScreen.buildRoute(
                            selectedOperation = selectedOperation
                        ))
                    }
                )
            }
            composable(route = MathMagicRoutes.GameStartScreen.route,
                arguments = listOf(
                    navArgument(SELECTED_OPERATION){
                        type = NavType.StringType
                    }
                )){backStackEntry ->
                val selectedOperation = backStackEntry.arguments?.getString(SELECTED_OPERATION, "")
                GameStartScreen(
                    modifier = modifier,
                    selectedOperation = selectedOperation ?: "",
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onProceedClick = {
                        navController.navigate(route = MathMagicRoutes.GameScreen.route)
                    }
                )
            }
            composable(route = MathMagicRoutes.GameScreen.route){
                GameScreen(
                    modifier = modifier,
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onProceedClick = {
                        navController.navigate(route = MathMagicRoutes.ValidateAnswerScreen.route)
                    }
                )
            }
            composable(route = MathMagicRoutes.ValidateAnswerScreen.route){
                ValidateAnswerScreen(
                    modifier = modifier,
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onProceedClick = {
                        navController.navigate(route = MathMagicRoutes.ResultDialogBox.route)
                    }
                )
            }
            composable(route = MathMagicRoutes.ResultDialogBox.route){
                ResultDialogBox(
                    modifier = modifier,
                    exitGame = {
                        onFinish()
                    },
                    playAgain = {
                        navController.navigate(route = MathMagicRoutes.HomeScreen.route)
                    }
                   )
            }
        }
    }


}