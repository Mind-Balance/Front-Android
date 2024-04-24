package com.salvamoreno.mindbalance.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.salvamoreno.mindbalance.ui.changeForgottenPass.ChangeForgottenPassScreen
import com.salvamoreno.mindbalance.ui.passForgotten.PassForgottenScreen
import com.salvamoreno.mindbalance.ui.passForgotten.PassForgottenViewModel

@Composable
fun MindBalanceAppNavigation(
    navController: NavHostController,
    passForgottenViewModel: PassForgottenViewModel,
) {
    NavHost(navController = navController, startDestination = Routes.PassForgottenScreen.route) {
        // PASSWORD FORGOTTEN SCREEN
        composable(Routes.PassForgottenScreen.route) {
            PassForgottenScreen(passForgottenViewModel = passForgottenViewModel) {
                navController.navigate(Routes.ChangeForgottenPass.route)
            }
        }
        // CHANGE FORGOTTEN PASSWORD SCREEN
        composable(Routes.ChangeForgottenPass.route) {
            ChangeForgottenPassScreen()
        }
    }
}