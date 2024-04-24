package com.salvamoreno.mindbalance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.salvamoreno.mindbalance.ui.navigation.MindBalanceAppNavigation
import com.salvamoreno.mindbalance.ui.passForgotten.PassForgottenScreen
import com.salvamoreno.mindbalance.ui.passForgotten.PassForgottenViewModel
import com.salvamoreno.mindbalance.ui.theme.MindBalanceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // VIEW MODELS
    private val passForgottenViewModel: PassForgottenViewModel by viewModels()

    // LIFECYCLE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindBalanceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MindBalanceAppNavigation(
                        navController = navController,
                        passForgottenViewModel = passForgottenViewModel
                    )
                }
            }
        }
    }
}
