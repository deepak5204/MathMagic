package com.example.mathmagic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mathmagic.navigation.MathMagicNavGraph
import com.example.mathmagic.navigation.MathMagicRoutes
import com.example.mathmagic.screen.GameScreen
import com.example.mathmagic.screen.HomeScreen
import com.example.mathmagic.ui.theme.MathMagicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MathMagicNavGraph(
                modifier = Modifier.fillMaxSize(),
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