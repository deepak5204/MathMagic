package com.example.mathmagic.screen

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathmagic.ui.theme.MathMagicTheme
import kotlinx.coroutines.delay
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    totalValue: Int,
    timeDifference: Int,
    onBackClick: () -> Unit,
    initialValue: String,
    onProceedClick: (calculatedValue: String) -> Unit,
    onRetryClick: (totalValue: String, timeDifference: String) -> Unit
) {
    val isButtonEnable = remember { mutableStateOf(false) }
    val counter = remember { mutableStateOf(1) }
    val currentNumber = remember { mutableStateOf(Random.nextInt(1, 100)) }
    val calculatedValue = remember { mutableIntStateOf(currentNumber.value) }

    LaunchedEffect(Unit) {
        while (counter.value < totalValue) {
            delay(timeDifference.toLong())
            currentNumber.value = Random.nextInt(1, 100)
            calculatedValue.intValue += currentNumber.value
            counter.value++
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text( text = "Game Screen") },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackClick()
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            isButtonEnable.value = counter.value == totalValue

            val bgColor = if (isButtonEnable.value)
                colorResource(id = R.color.holo_blue_dark)
            else
                colorResource(id = R.color.darker_gray)

            BottomAppBar {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Button(
                        onClick = {
                            if(isButtonEnable.value){
                                onRetryClick(totalValue.toString(), timeDifference.toString())
                            }
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = bgColor)
                    ) {
                        Text("Retry")
                    }


                    Button(
                        onClick = {
                            if(isButtonEnable.value){
                                onProceedClick(calculatedValue.value.toString())
                            }
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = bgColor)
                    ) {
                        Text("Proceed")
                    }
                }
            }

        }
    ) {
        Box(
            modifier = Modifier.padding(it)
                .padding(16.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
                Text(
                    text = currentNumber.value.toString(),
                    fontSize = 250.sp,
                    modifier = Modifier.padding(4.dp))

        }
    }
}

@Preview
@Composable
private fun GameScreenPreview() {
    MathMagicTheme {
//        GameScreen(
//            totalValue = 0,
//            timeDifference = 0,
//            onBackClick = {},
//            onProceedClick = {}
//        )
    }
}