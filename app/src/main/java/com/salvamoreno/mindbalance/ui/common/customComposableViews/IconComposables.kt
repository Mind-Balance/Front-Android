package com.salvamoreno.mindbalance.ui.common.customComposableViews

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BackIcon() {
    Icon(
        imageVector = Icons.Default.KeyboardArrowLeft,
        contentDescription = "Back Icon",
        tint = Color.White
    )
}

@Preview
@Composable
fun PreviewBackIcon() {
    BackIcon()
}