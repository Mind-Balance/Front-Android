package com.salvamoreno.mindbalance.ui.common.customComposableViews

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BackIcon(
    onBack: () -> Unit
) {
    Icon(
        imageVector = Icons.Default.KeyboardArrowLeft,
        contentDescription = "Back Icon",
        tint = Color.White,
        modifier = Modifier.clickable {
            onBack()
        }
    )
}
