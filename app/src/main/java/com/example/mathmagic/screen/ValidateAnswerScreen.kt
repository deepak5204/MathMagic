package com.example.mathmagic.screen

import android.R.attr.onClick
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ValidateAnswerScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onProceedClick: (finalAnswer: String) -> Unit
) {
    val userAnswer = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE3F3CF))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Column(){
            Text(
                text = "Enter you answer",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = userAnswer.value,
                onValueChange = {
                    userAnswer.value = it
                },
                placeholder = { Text(
                    text = "Enter your answer...",
                )},
                modifier = Modifier,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
        }

        Spacer(modifier = Modifier.height(200.dp))

        Button(
            onClick = {
                onProceedClick(userAnswer.value.toString())
            }
        ) {
            Text("Validate Answer")
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ValidateAnswerScreenPreview() {
    ValidateAnswerScreen(
        onBackClick = {},
        onProceedClick = {}
    )

    
}