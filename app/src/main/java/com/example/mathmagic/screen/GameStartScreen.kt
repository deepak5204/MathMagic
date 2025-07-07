package com.example.mathmagic.screen

import android.R
import android.R.attr.fontWeight
import android.R.attr.text
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathmagic.MainActivity.Companion.ADDITION
import com.example.mathmagic.MainActivity.Companion.DIVISION
import com.example.mathmagic.MainActivity.Companion.MULTIPLICATION
import com.example.mathmagic.MainActivity.Companion.SUBTRACTION
import com.example.mathmagic.ui.theme.MathMagicTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameStartScreen(
    modifier: Modifier = Modifier,
    selectedOperation: String,
    onBackClick: () -> Unit,
    onProceedClick: () -> Unit
) {
    val isStartEnable = remember { mutableStateOf(false) }
    val totalValues = remember { mutableStateOf("") }
    val timeDifference = remember { mutableStateOf("") }

    Log.d("TAG", "GameStartScreen: $selectedOperation")
    Log.d("TAG", "GameStartScreen: $ADDITION")
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Game Start Screen") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {

            isStartEnable.value =
                totalValues.value.isNotEmpty() && timeDifference.value.isNotEmpty()

            val bgColor = if (isStartEnable.value)
                colorResource(id = R.color.holo_blue_dark)
            else
                colorResource(id = R.color.darker_gray)

            BottomAppBar {
                Button(
                    onClick = {
                        if (isStartEnable.value) {
                            onProceedClick()
                        }
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = bgColor)
                ) {
                    Text("Start Game")
                }
            }
        }) {

        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Selected Operation", fontSize = 25.sp, fontWeight = FontWeight.Bold
                )

                val selectedValue =
                    when (selectedOperation) {
                        ADDITION -> {
                            "+"
                        }

                        SUBTRACTION -> {
                            "-"
                        }

                        MULTIPLICATION -> {
                            "X"
                        }


                        else -> {
                            "/"
                        }
                    }

                Text(
                    text = selectedValue, fontSize = 100.sp, fontWeight = FontWeight.Bold
                )
            }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Enter total number of values",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(2.dp))
                OutlinedTextField(value = totalValues.value, onValueChange = {
                    totalValues.value = it
                }, placeholder = {
                    Text(
                        text = "Enter Number...",
                    )
                }, modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
                )


                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Enter time difference in milliseconds",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(2.dp))
                OutlinedTextField(value = timeDifference.value, onValueChange = {
                    timeDifference.value = it
                }, placeholder = {
                    Text(
                        text = "Enter time difference...",
                    )
                }, modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
                )

            }
        }
    }


@Preview
@Composable
private fun GameStartScreenPreview() {
    MathMagicTheme {
        GameStartScreen(
            onBackClick = {},
            onProceedClick = {},
            selectedOperation = "",

        )
    }
}