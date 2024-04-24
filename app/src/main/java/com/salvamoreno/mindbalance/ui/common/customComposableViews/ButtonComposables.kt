package com.salvamoreno.mindbalance.ui.common.customComposableViews

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salvamoreno.mindbalance.ui.theme.loginTerciary

@Composable
fun NormalButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, loginTerciary),
                    startY = 0f,
                    endY = Float.POSITIVE_INFINITY
                ),
                shape = RoundedCornerShape(6.dp)
            )
            .border(
                border = BorderStroke(1f.dp, loginTerciary),
                shape = RoundedCornerShape(6.dp)
            )
            .height(48.dp)
            .fillMaxWidth()
    ) {
        Button(
            modifier = Modifier.fillMaxSize(),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            ),
        ) {
            Text(text = text, style = MaterialTheme.typography.titleMedium)
        }
    }

}

@Preview
@Composable
fun PreviewNormalButton() {
    NormalButton(text = "Confirmar identidad") {
        onClick()
    }
}

fun onClick() {
    println("Click!")
}