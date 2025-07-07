package com.example.mathmagic.screen

import android.R
import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
fun HomeScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onProceedClick: (selectedOperation: String) -> Unit
) {

    var selectedOperation = remember { mutableStateOf<String?>(null) }

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Math Magic") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            val bgColor = if (selectedOperation.value != null)
                colorResource(id = R.color.holo_blue_dark)
            else
                colorResource(id = R.color.darker_gray)

            BottomAppBar {
                Button(
                    onClick = {
                        if(selectedOperation.value != null){
                            onProceedClick(selectedOperation.value.toString())
                        }
                    },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = bgColor)
                ) {
                    Text("Proceed")
                }
            }
        }

    ){
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "Select Your Operation",
                fontSize = 30.sp
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .clickable{
                            selectedOperation.value = ADDITION
                        },
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "+",
                        fontSize = 200.sp,
                    )
                }

                Box(
                    modifier = Modifier
                        .clickable{
                            selectedOperation.value = SUBTRACTION
                        },
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "-",
                        fontSize = 200.sp
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .clickable{
                            selectedOperation.value = MULTIPLICATION
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "X",
                        fontSize = 200.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .clickable{
                            selectedOperation.value = DIVISION
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "/",
                        fontSize = 170.sp
                    )
                }
            }
        }

    }
}

@Preview
@Composable
private fun HomeScreenPrev() {
    MathMagicTheme {
        HomeScreen(
            onBackClick = {},
            onProceedClick = {}
        )
    }
}