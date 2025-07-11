package com.example.mathmagic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mathmagic.navigation.MathMagicNavGraph
import com.example.mathmagic.navigation.MathMagicRoutes
import com.example.mathmagic.screen.GameScreen
import com.example.mathmagic.screen.HomeScreen
import com.example.mathmagic.ui.theme.MathMagicTheme
import com.example.mathmagic.viewModel.MathMagicViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MathMagicViewModel  by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MathMagicNavGraph(
                modifier = Modifier.fillMaxSize(),
                viewModel = viewModel,
                startDestination = MathMagicRoutes.HomeScreen.route,
                onFinish = {
                    finish()
                }
            )
        }
    }

    companion object {
        const val ADDITION = "Addition"
        const val SUBTRACTION = "Subtraction"
        const val MULTIPLICATION = "Multiplication"
        const val DIVISION = "Division"
        const val SELECTED_OPERATION= "selectedOperation"
        const val TOTAL_VALUE = "totalValue"
        const val TIME_DIFFERENCE = "timeDifference"
        const val INITIAL_VALUE = "initialValue"
        const val FINAL_ANSWER = "finalAnswer"
        const val CALCULATED_VALUE = "calculatedValue"
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MathMagicTheme {
        Greeting("Android")
    }
}