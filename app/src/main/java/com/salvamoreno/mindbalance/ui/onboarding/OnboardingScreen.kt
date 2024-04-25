package com.salvamoreno.mindbalance.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.salvamoreno.mindbalance.ui.theme.loginSecondary

@Composable
fun OnboardingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                loginSecondary
            )
    ) {
        Text("Onboarding Screen", fontSize = 50.sp)
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    OnboardingScreen()
}