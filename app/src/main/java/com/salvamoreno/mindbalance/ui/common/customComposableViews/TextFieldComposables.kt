package com.salvamoreno.mindbalance.ui.common.customComposableViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.PermIdentity
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salvamoreno.mindbalance.R
import com.salvamoreno.mindbalance.ui.theme.loginSecondary
import com.salvamoreno.mindbalance.ui.theme.loginTerciary

@Composable
fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "Email",
    leadingIcon: ImageVector = Icons.Outlined.PermIdentity
) {
    Box(modifier = Modifier
        .height(64.dp)
        .fillMaxWidth()
        .background(
            color = Color.Transparent,
            shape = RoundedCornerShape(6.dp)
        )
    ) {
        TextField(
            modifier = Modifier.fillMaxSize(),
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = "Email Icon")},
            singleLine = true,
            shape = RoundedCornerShape(6.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = loginSecondary,
                disabledContainerColor = loginSecondary,
                focusedContainerColor = loginTerciary,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                focusedLabelColor = loginSecondary
            )
        )
    }
}

@Composable
fun DNITextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "DNI",
    leadingIcon: ImageVector = Icons.Outlined.CreditCard
) {
    Box(modifier = Modifier
        .height(64.dp)
        .fillMaxWidth()
        .background(
            color = Color.Transparent,
            shape = RoundedCornerShape(6.dp)
        )
    ) {
        TextField(
            modifier = Modifier.fillMaxSize(),
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = "DNI Icon")},
            singleLine = true,
            shape = RoundedCornerShape(6.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = loginSecondary,
                disabledContainerColor = loginSecondary,
                focusedContainerColor = loginTerciary,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                focusedLabelColor = loginSecondary
            )
        )
    }
}

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "Contraseña",
    leadingIcon: ImageVector = Icons.Filled.Lock
) {
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        leadingIcon = { Icon(imageVector = leadingIcon, contentDescription = "DNI Icon")},
        trailingIcon = {
            IconButton(onClick = {
                isPasswordVisible = !isPasswordVisible
            }) {

                val visibleIconAndText = Pair(
                    first = Icons.Outlined.Visibility,
                    second = stringResource(id = R.string.icon_password_visible)
                )

                val hiddenIconAndText = Pair(
                    first = Icons.Outlined.VisibilityOff,
                    second = stringResource(id = R.string.icon_password_hidden)
                )

                val passwordVisibilityIconAndText =
                    if (isPasswordVisible) visibleIconAndText else hiddenIconAndText

                // Render Icon
                Icon(
                    imageVector = passwordVisibilityIconAndText.first,
                    contentDescription = passwordVisibilityIconAndText.second
                )
            }
        },
        singleLine = true,
        shape = RoundedCornerShape(6.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = loginSecondary,
            disabledContainerColor = loginSecondary,
            focusedContainerColor = loginTerciary
        )
    )
}

@Preview
@Composable
fun PreviewEmailTextField() {
    EmailTextField(
        value = "",
        onValueChange = { onValueChange() }
    )
}

@Preview
@Composable
fun PreviewDNITextField() {
    DNITextField(
        value = "",
        onValueChange = { onValueChange() }
    )
}

@Preview
@Composable
fun PreviewPasswordTextField() {
    PasswordTextField(
        value = "",
        onValueChange = { onValueChange() }
    )
}

fun onValueChange() {}