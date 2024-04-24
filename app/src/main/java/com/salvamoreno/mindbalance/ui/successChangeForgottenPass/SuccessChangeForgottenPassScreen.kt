package com.salvamoreno.mindbalance.ui.successChangeForgottenPass

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salvamoreno.mindbalance.ui.common.customComposableViews.BackIcon
import com.salvamoreno.mindbalance.ui.common.customComposableViews.DNITextField
import com.salvamoreno.mindbalance.ui.common.customComposableViews.EmailTextField
import com.salvamoreno.mindbalance.ui.common.customComposableViews.NormalButton
import com.salvamoreno.mindbalance.ui.passForgotten.onConfirmIdentity
import com.salvamoreno.mindbalance.ui.theme.loginPrimary

@Composable
fun SuccessChangeForgottenPassScreen(
    onNavigateToLogin: () -> Unit
) {
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
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp)
            ) {
                Text(
                    text = "✅",
                    color = Color.White,
                    fontSize = 100.sp
                )
                Text(
                    text = "¡Ya tienes nueva contraseña!",
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = "Tu contraseña ha sido cambiada con éxito",
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier.padding(top = 6.dp)
            ) {
                NormalButton(text = "Volver a Inicio de Sesión") {
                    onNavigateToLogin()
                }
            }
        }
    }
}
