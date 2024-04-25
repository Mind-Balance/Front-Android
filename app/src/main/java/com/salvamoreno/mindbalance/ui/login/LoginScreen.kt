package com.salvamoreno.mindbalance.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salvamoreno.mindbalance.ui.common.customComposableViews.EmailTextField
import com.salvamoreno.mindbalance.ui.common.customComposableViews.NormalButton
import com.salvamoreno.mindbalance.ui.common.customComposableViews.PasswordTextField
import com.salvamoreno.mindbalance.ui.theme.loginPrimary
import com.salvamoreno.mindbalance.ui.theme.loginSecondary

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel,
    onChangeForgottenPassword: () -> Unit,
    onAccessTokenEmpty: () -> Unit,
    onAccessTokenReceived: () -> Unit
) {
    // OBSERVERS
    val accessToken by loginViewModel.accessToken.collectAsState()

    // PROPERTIES
    var emailValue by remember {
        mutableStateOf("")
    }

    var passwordValue by remember {
        mutableStateOf("")
    }

    // ACTION
    when (accessToken) {
        "vacio" -> {
            onAccessTokenEmpty()
        }
        "nada" -> { }
        else -> {
            onAccessTokenReceived()
        }
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
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 150.dp)
            ) {
                Text(
                    text = "¡Hola! Qué gusto verte por aquí",
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = "Shhh... No se lo digas a tu jefe, pero aquí se viene a desconectar",
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
                PasswordTextField(
                    value = passwordValue,
                    onValueChange = {
                        passwordValue = it
                    })
                NormalButton(text = "Iniciar sesión") {
                    loginViewModel.onSignIn(emailValue, passwordValue)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Olvidé mi contraseña",
                        color = loginSecondary,
                        fontSize = 13.sp,
                        modifier = Modifier
                            .clickable {
                                onChangeForgottenPassword()
                            }
                    )
                }
            }
        }
    }
}
