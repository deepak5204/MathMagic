package com.example.mathmagic.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.mathmagic.ui.theme.MathMagicTheme
import com.example.mathmagic.R

@Composable
fun ResultDialogBox(
    modifier: Modifier = Modifier,
    finalAnswer: String,
    calculateAnswer: String,
    exitGame: () -> Unit,
    playAgain: () -> Unit,
    onBackClick: () -> Unit = {}
) {

    if (finalAnswer.toInt() == calculateAnswer.toInt()) {
        Dialog(onDismissRequest = exitGame) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // 🎉 Background Image (top)
                    Image(
                        painter = painterResource(id = R.drawable.ic_win_image), // Replace with your drawable
                        contentDescription = "Victory Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // 🏆 Title
                    Text(
                        text = "You Won the Game!",
                        style = MaterialTheme.typography.headlineSmall.copy(fontSize = 22.sp),
                        color = Color(0xFF388E3C)
                    )


                    Spacer(modifier = Modifier.height(24.dp))

                    // ✅ Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)

                    ) {
                        OutlinedButton(
                            onClick = exitGame,
                            modifier = Modifier.weight(1f).padding(start = 8.dp)
                        ) {
                            Text("Exit")
                        }

                        Button(
                            onClick = playAgain,
                            modifier = Modifier.weight(1f).padding(end = 8.dp)
                        ) {
                            Text("Play Again")
                        }
                    }
                }
            }
        }
    }
    else {

        Dialog(onDismissRequest = exitGame) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // 🎉 Background Image (top)
                    Image(
                        painter = painterResource(id = R.drawable.ic_game_over), // Replace with your drawable
                        contentDescription = "Victory Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // 🏆 Title
                    Text(
                        text = "You Loss!! Better Luck Next time..",
                        style = MaterialTheme.typography.headlineSmall.copy(fontSize = 22.sp),
                        color = Color(0xFF388E3C)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // ✅ Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)

                    ) {
                        OutlinedButton(
                            onClick = exitGame,
                            modifier = Modifier.weight(1f).padding(start = 8.dp)
                        ) {
                            Text("Exit")
                        }

                        Button(
                            onClick = playAgain,
                            modifier = Modifier.weight(1f).padding(end = 8.dp)
                        ) {
                            Text("Play Again")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WinOrLossScreenPreview() {
    MathMagicTheme {
        ResultDialogBox(
            exitGame = {},
            playAgain = {},
            finalAnswer = "100",
            calculateAnswer = "100"
        )
    }
}