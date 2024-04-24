package com.salvamoreno.mindbalance.ui.passForgotten

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salvamoreno.mindbalance.ui.common.customComposableViews.BackIcon
import com.salvamoreno.mindbalance.ui.common.customComposableViews.DNITextField
import com.salvamoreno.mindbalance.ui.common.customComposableViews.EmailTextField
import com.salvamoreno.mindbalance.ui.common.customComposableViews.NormalButton
import com.salvamoreno.mindbalance.ui.theme.loginPrimary

@Composable
fun PassForgottenScreen(
    passForgottenViewModel: PassForgottenViewModel,
    onBack: () -> Unit,
    onIdentityConfirmed: () -> Unit
) {
    var emailValue by remember {
        mutableStateOf("")
    }

    var dniValue by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        loginPrimary.copy(alpha = 0.6f),
                        loginPrimary,
                        loginPrimary,
                        loginPrimary
                    ),
                    startY = 0f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
            .padding(16.dp)
            .padding(top = 36.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BackIcon(
                onBack
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = "¿Has olvidado tu contraseña?",
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = "Por favor, introduce el email asociado a tu cuenta y tu DNI",
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier.padding(top = 6.dp)
            ) {
                EmailTextField(
                    value = emailValue,
                    onValueChange = {
                        emailValue = it
                    }
                )
                DNITextField(
                    value = dniValue,
                    onValueChange = {
                        dniValue = it
                    }
                )
                NormalButton(text = "Confirmar identidad") {
                    passForgottenViewModel.onConfirmIdentity(emailValue, dniValue)
                    onIdentityConfirmed()
                }
            }
        }
    }
}
