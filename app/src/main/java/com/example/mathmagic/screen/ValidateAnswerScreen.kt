package com.example.mathmagic.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ValidateAnswerScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onProceedClick: () -> Unit
) {
    val userAnswer = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = "Enter time difference in milliseconds",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {
                userAnswer.value = it
            },
            placeholder = { Text(
                text = "Enter your answer...",
            )},
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(200.dp))

        Button(
            onClick = {
                onProceedClick()
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