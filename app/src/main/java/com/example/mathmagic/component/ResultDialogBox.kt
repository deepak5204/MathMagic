package com.example.mathmagic.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mathmagic.ui.theme.MathMagicTheme

@Composable
fun ResultDialogBox(
    modifier: Modifier = Modifier,
    exitGame: () -> Unit,
    playAgain: () -> Unit
) {

}

@Preview(showBackground = true)
@Composable
private fun WinOrLossScreenPreview() {
    MathMagicTheme {
        ResultDialogBox(
            exitGame = {},
            playAgain = {}
        )
    }
}